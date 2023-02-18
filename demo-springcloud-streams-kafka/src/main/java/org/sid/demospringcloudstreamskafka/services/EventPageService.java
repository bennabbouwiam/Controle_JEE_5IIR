package org.sid.demospringcloudstreamskafka.services;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.sid.demospringcloudstreamskafka.entities.EventPage;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class EventPageService {
    //créer un consumer qui va consommer des objets de type EventPage
    //cette fonction va retourner un consumer
    //Pour que l'application soit déployée => @Bean

    @Bean
    public Consumer<EventPage> eventPageConsumer(){
        return (input)->{

            System.out.println("*********************");
            System.out.println(input.toString());
            System.out.println("*********************");


        };
    }

    //un producer
    @Bean
    public Supplier<EventPage> eventPageSupplier(){
        return ()-> new EventPage(
                Math.random()>0.5?"P1":"P2",
                Math.random()>0.5?"U1":"U2",
                new Date(),
                new Random().nextInt(9000));
    }

    //deployer une fonction qui consomme(consumer) et produire (producer)
    @Bean
    public Function<EventPage,EventPage> eventPageFunction(){
        return (input)->{
            //input.setName("Page Event");
            input.setName("L: "+input.getName().length());
            input.setUser("UUUUU");
            return input;
        };
    }

    //kafla streams
    //consommer un KStream en input et produire un autre KStream qui contient la clé : nom de la page , et la valeur :
    //c'est le nbr de fois de visite de la page
    @Bean
    public Function<KStream<String,EventPage>, KStream<String,Long>> KStreamFunction(){
        return (input)->{
            //filtrer les données : traiter que les évenements de visite de page dont la durée de visite dépasse 100ms
            return input
                    .filter((k,v)->v.getDuration()>100)
                    //produire un stream dans lequel la clé est le nom de la page et la valeur 0 (KTable)
                    .map((k,v)->new KeyValue<>(v.getName(),0L))
                    //grouper par la clé : nom de la page
                    .groupBy((k,v)->k,Grouped.with(Serdes.String(),Serdes.Long()))
                    .windowedBy(TimeWindows.of(Duration.ofSeconds(5)))
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k,v)->new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));

        };
    }


}
