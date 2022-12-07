# Rapport détaillé
## Enoncé : 
### Objectif :  
Créer une application basée sur une architecture micro-service qui permet de gérer les factures contenant des produits et appartenant à un client.

#### Travail à faire :
 - Créer le micro-service customer-service qui permet de gérer les clients
 - Créer le micro-service inventory-service qui permet de gérer les produits
 - Créer la Gateway Spring cloud Gateway avec une Configuration statique du système de routage
 - Créer l'annuaire Eureka Discrovery Service
 - Faire une configuration dynamique des routes de la gateway
 - Créer le service de facturation Billing-Service en utilisant Open Feign
 - Créer un client Web Angular (Clients, Produits, Factures)
 - Déployer le serveur keycloak :
     - Créer un Realm
     - Créer un client à sécuriser
     - Créer des utilisateurs
     - Créer des rôles
     - Affecter les rôles aux utilisateurs
     - Tester les différents modes d'authentification avec Postman en montrant les contenus de Access-Token, Refresh Token 
 - Sécuriser les micro-services et le frontend angular en déployant les adaptateurs Keycloak
 - Ajouter des Fonctionnalités supplémentaires de votre choix
 - Livrable : Un Repository Github contenant :
   - Le code source de l'ensemble des micro-services et du frontend
   - Le rapport montrant les différentes étapes dans le fichier README.MD

## Architectures :
-	Objectif 1 : Mise en œuvre des architectures micro-services avec Spring Cloud

![image](https://user-images.githubusercontent.com/80289154/206286792-f7866c95-9ef7-484c-a37f-cd4cb1948790.png)

1.	Créer le micro service Customer-service
  • Créer l’entité Customer 
  • Créer l’interface CustomerRepository basée sur Spring Data 
  • Déployer l’API Restful du micro-service en utilisant Spring Data Rest
  • Tester le Micro service

2.	Créer le micro service Inventory-service
  • Créer l’entité Product
  • Créer l’interface ProductRepository basée sur Spring Data
  • Déployer l’API Restful du micro-service en utilisant Spring Data Rest 
  • Tester le Micro service
3.  Créer la Gateway service en utilisant Spring Cloud Gateway
  - Tester le Service proxy en utilisant une configuration Statique basée
    sur le fichier application.yml 
  - Tester le Service proxy en utilisant une configuration Statique basée
    sur une configuration Java
4. Créer l’annuaire Registry Service basé sur NetFlix Eureka Server
5. Tester le proxy en utilisant une configuration dynamique de Gestion des
    routes vers les micro services enregistrés dans l’annuaire Eureka Server
6. Créer Le service Billing-Service en utilisant Open Feign pour
    communiquer avec les services Customer-service et Inventory-service
7.  Créer un client Angular qui permet d’afficher une facture

- Objectif 2 : Sécuriser les parties Frontend et Backend d’une application avec Keycloak

![image](https://user-images.githubusercontent.com/80289154/206288083-ed440986-d9fe-4b1c-9ed1-4ed984da80e3.png)

1. Prise en main de keycloak
- Télécharger Keycloak 12.0.1, Démarrer Keycloak
- Créer le Realm « my-ecom-realm » / Créer un client à sécuriser
- Créer des utilisateurs, Créer des rôles, Affecter les rôles aux utilisateurs
- Tester l’authentification des utilisateurs en utilisant un client Rest comme ARC
- Authentification avec le mot de passe
- Authentification avec le Refresh Token
- Personnaliser le paramétrage des timeout des tokens
2. Récupérer et tester le code source des deux applications à sécuriser à partir du repository Github (
https://github.com/mohamedYoussfi )
- «products-app-kc » : Application Frontend basée sur Thymeleaf qui permet de gérer des produits et des fournisseurs
- «supplieurs-service-kc » : Application Backend Micro-service permettant de gérer les fournisseurs
3. Sécuriser l’application Frontend en mode public client
4. Sécuriser le micro-service en mode Bearer only
5. Lier le frontend avec le backend en utilisant KeycloakRestTemplate pour afficher la liste des fournisseurs dans la partie Frontend

### Partie 1 : le micro-service customer-service qui permet de gérer les clients

![image](https://user-images.githubusercontent.com/80289154/206288722-62bacc57-056f-4a4d-a498-cbfc41b6614d.png)

- Accéder à la liste des clients à partir de Spring Data Rest 

![image](https://user-images.githubusercontent.com/80289154/206288797-2d3e102e-4746-4728-9e64-2ccfe269108d.png)

![image](https://user-images.githubusercontent.com/80289154/206289523-19ee9a4d-0a3d-424d-9324-30a5b8dcd0ea.png)

- La liste des clients dans la base de données H2

![image](https://user-images.githubusercontent.com/80289154/206289608-514c649d-e0c5-43d6-8138-88aff51c144c.png)

### Partie 2 : Créer le micro-service inventory-service qui permet de gérer les produits
 
![image](https://user-images.githubusercontent.com/80289154/206289670-dede2bb4-dcf8-44ec-9aad-5b76ea262843.png)

- Accéder à la liste des produits à partir de Spring Data Rest

![image](https://user-images.githubusercontent.com/80289154/206289753-6d2b39f0-7fdb-4413-b157-c7843f17b2fb.png)

![image](https://user-images.githubusercontent.com/80289154/206289795-ad13adca-ed6d-405f-9f13-e11a188cf791.png)

### Partie 3 : Créer la Gateway Spring cloud Gateway avec une Configuration statique du système de routage
•	Configuration statique : 1ère méthode

![image](https://user-images.githubusercontent.com/80289154/206289937-9c32c9c3-42f3-465d-a6ff-dbb3d672eabc.png)

- Accéder au micro service customer 

![image](https://user-images.githubusercontent.com/80289154/206289998-25320aa6-7591-4262-97d9-c382bef0b166.png)

- Accéder au micro service des produits 

![image](https://user-images.githubusercontent.com/80289154/206290058-d9da3293-2f2d-46e9-8101-fcc1dca3f485.png)

•	Configuration statique : 2ème méthode
=> Une classe java au lieu d’un fichier config.yml

![image](https://user-images.githubusercontent.com/80289154/206290218-8dde9a36-65c3-4186-9fa2-398475c9c874.png)

### Partie 4 : Créer l'annuaire Eureka Discrovery Service

![image](https://user-images.githubusercontent.com/80289154/206290694-3ad47014-423f-46c4-8fcd-36d48e7e048e.png)

- Enregistrer les micro services dans eureka discovery après la configuration de quelques paramètres dans le fichier properties de config.

![image](https://user-images.githubusercontent.com/80289154/206290771-4a6a5c55-d8ba-4184-ae11-2268edc977e4.png)

- Accéder aux micros services crées CUSTOMER-SERVICE et INVENTORY-SERVICE à partir de Eureka discovery et spring data rest 

![image](https://user-images.githubusercontent.com/80289154/206290849-2a1adeb0-37f0-4794-a9fd-7502579a3cc0.png)

![image](https://user-images.githubusercontent.com/80289154/206290893-cf99dbf1-8c6e-4d3b-98df-753c1ac68458.png)

### Partie 5 :  Faire une configuration dynamique des routes de la gateway

![image](https://user-images.githubusercontent.com/80289154/206290998-ee6e5a09-4b60-4e07-adfa-4ec994a12b4e.png)

### Partie 6 :  Créer le service de facturation Billing-Service en utilisant Open Feign
- La liste des factures dans la base de données H2

![image](https://user-images.githubusercontent.com/80289154/206291143-8b4f4750-63ef-4523-9617-0862a009244c.png)

![image](https://user-images.githubusercontent.com/80289154/206291262-33edfd5f-3b9d-476c-ad45-050cf5c0d06e.png)

=> Si on veut exposer l’id du client ou du produitItem :
 - Soit par la projection 
 - Soit à travers un objet de type RepositoryRestConfiguration

![image](https://user-images.githubusercontent.com/80289154/206291380-2cbd5382-fbc6-4f6e-b715-9895a8a0e7a7.png)

![image](https://user-images.githubusercontent.com/80289154/206291422-ffef11e5-8a6b-4d0a-8951-8e10c33912a5.png)

- La liste des Products Item dans la facture :

![image](https://user-images.githubusercontent.com/80289154/206291495-a48de754-7999-480d-81f8-d480e3e28e8f.png)

- Récupérer le détail de la facture à travers une API Rest : web service de bill

![image](https://user-images.githubusercontent.com/80289154/206291724-02ef00d4-05d8-4048-a7fa-2a8bce7497e9.png)

- Après JsonProperty : 

![image](https://user-images.githubusercontent.com/80289154/206291831-cbb632a2-a756-4faf-85ac-b23d46b53c70.png)

- Accéder au micro service BILLING-SERVICE à travers Eureka et API REST générique de Spring Data Rest

![image](https://user-images.githubusercontent.com/80289154/206291897-c864f457-9705-453b-b4c2-18517af92247.png)

- Accéder au micro-service BILLING-SERVICE à travers Eureka et web service Rest Controller

![image](https://user-images.githubusercontent.com/80289154/206291957-b29a2823-1423-4b02-898d-531f6d6d6465.png)

- On a essayé de récupérer le produit et le client à travers Rest c’est-à-dire on a communiqué 
avec les autres micro services en utilisant Open Feign à travers la création d’un package feign qui comporte les interfaces 
contenant les méthodes de récupération de données et en précisant l’annotation @FeignClient

![image](https://user-images.githubusercontent.com/80289154/206292137-3f6eea3e-04a3-4544-81f1-295c4535e6f7.png)

### Partie 7 :  Créer un client Web Angular (Clients, Produits, Factures)
- Créer un projet Angular avec la commande : "ng new project_name"

![image](https://user-images.githubusercontent.com/80289154/206292247-c586edba-b2d2-4874-971b-e2de716737d0.png)

![image](https://user-images.githubusercontent.com/80289154/206292273-d8315b4d-c18d-4bed-aa1c-dc777c461e02.png)

- Tester avec la commande : "ng serve"

![image](https://user-images.githubusercontent.com/80289154/206292529-c177e193-1221-4fbf-9df8-224eb1f30c74.png)

![image](https://user-images.githubusercontent.com/80289154/206292557-6326164a-c302-4c95-9fd7-82d431599e58.png)

- Installer les dépendances : bootstrap avec la commande : "npm install –save bootstrap bootstrap-icons"

![image](https://user-images.githubusercontent.com/80289154/206292658-287555ba-89aa-4de8-a42b-23a5767452a8.png)

![image](https://user-images.githubusercontent.com/80289154/206292697-3a08ce6e-837b-46f4-9813-b09c887fb528.png)

- Générer des components (composants), la commande : "ng g c products"

![image](https://user-images.githubusercontent.com/80289154/206292764-76e0f36e-76f9-461f-8ed1-3e482d93f176.png)

- Tester le résultat : la liste des produits 

![image](https://user-images.githubusercontent.com/80289154/206292828-1dbd818e-7d1d-487f-812c-9e145c0d2f55.png)

- Autre composant : customer et le test du résultat : la liste des clients

![image](https://user-images.githubusercontent.com/80289154/206292876-f2ba92f3-3b8a-4399-941b-9fe645f06021.png)

- Autre component factures et le test du résultat : la liste des factures

![image](https://user-images.githubusercontent.com/80289154/206292925-50efb90e-d902-4c79-a2c8-e8494a56b187.png)

- Récupérer les factures d’un client 

![image](https://user-images.githubusercontent.com/80289154/206292998-8aa77dd1-23d9-46e1-ba7b-67801baf9551.png)

![image](https://user-images.githubusercontent.com/80289154/206293036-ab454424-5fec-41fc-a652-56202f17484c.png)

![image](https://user-images.githubusercontent.com/80289154/206293075-4efd9b57-81e7-40f4-8f2d-320127730509.png)

- Avec projection 

![image](https://user-images.githubusercontent.com/80289154/206293144-eb35a566-64d7-4959-aa60-dec9db4e18fd.png)

- Tester le résultat 

![image](https://user-images.githubusercontent.com/80289154/206293218-76152b59-ffa8-44bb-83a5-041b3e111763.png)

![image](https://user-images.githubusercontent.com/80289154/206293251-7688d0c6-6d7f-4a30-88e1-57a40c4f740a.png)

- Autre composant : détail des factures

![image](https://user-images.githubusercontent.com/80289154/206293314-2f44d01e-0210-4e77-9377-e0cf7e73408d.png)

![image](https://user-images.githubusercontent.com/80289154/206293347-d7492dc2-e5d6-424c-ba51-e3df845d5451.png)

- Facture avec le détail et les produits items

![image](https://user-images.githubusercontent.com/80289154/206293390-a94164ac-ce0c-467a-8ba8-3c13820596a3.png)

![image](https://user-images.githubusercontent.com/80289154/206293418-013d5321-a861-4b47-82a3-d0e5246dffb6.png)

- Product item avec total

![image](https://user-images.githubusercontent.com/80289154/206293478-4455eb01-228d-41d9-8d32-dd915b0605e2.png)

- Résultat final :

![image](https://user-images.githubusercontent.com/80289154/206293541-b8a55c05-f32e-4171-b88e-ce61d6a064d8.png)


### Partie 8 :  Déployer le serveur keycloak 

- Téléchargement et installation de keycloak

![image](https://user-images.githubusercontent.com/80289154/206307810-961fa534-5378-4d19-b8a7-cd1b13fe251d.png)

- Démarrer keycloak en mode build
  Commande : "kc.bat start-dev" => démarrer la version de keycloak basée sur le framework Quarkus
  
  ![image](https://user-images.githubusercontent.com/80289154/206308012-15eb06bf-7ed5-4733-8868-2cabfd7b4856.png)
  
  ![image](https://user-images.githubusercontent.com/80289154/206308070-925d7f4e-070b-47a1-94ea-4bd2bd41a470.png)
  
- Console d’administration : créer un admin  

![image](https://user-images.githubusercontent.com/80289154/206308245-1539b893-9353-49ea-bbd9-a289abf36021.png)

![image](https://user-images.githubusercontent.com/80289154/206308261-e3360314-7d92-49f3-9cc6-9496fd368982.png)

- Après la création d’un admin on accède à la console d’administration :
  - S’authentifier

![image](https://user-images.githubusercontent.com/80289154/206308515-47f63d9d-fe67-4c0f-aff6-af5314e9b6b0.png)

- Accéder à la console

![image](https://user-images.githubusercontent.com/80289154/206308568-a4066452-418c-4dd1-b2c7-c9a19bf6c1b8.png)

- Créer un realm : il va contenir les applications à sécuriser 

![image](https://user-images.githubusercontent.com/80289154/206308623-60f24314-b38c-4b5e-9ba6-b7a84f6c920f.png)

![image](https://user-images.githubusercontent.com/80289154/206308648-ad71d065-5c09-4e9c-8fce-0a4168032225.png)

- Créer un client à sécuriser 

![image](https://user-images.githubusercontent.com/80289154/206308708-2cfa6705-a186-40ac-afc7-8a5d91c34199.png)

![image](https://user-images.githubusercontent.com/80289154/206308742-39c85890-e6b1-4b72-8a7d-220ed80569d6.png)

![image](https://user-images.githubusercontent.com/80289154/206308772-d726dadb-7820-4d6a-9654-87b2c680f6ee.png)

- Quelques accès setting URLs :
   - Path de l’application Angular 

![image](https://user-images.githubusercontent.com/80289154/206308873-517fe4eb-d2ab-40b6-aaea-5b95b0aa49bc.png)

![image](https://user-images.githubusercontent.com/80289154/206308898-e85d8ff7-a17a-4cdb-9704-71c1c4375077.png)

- Créer des utilisateurs qui ont le droit d’accéder à l’application sécurisée (clientID)

![image](https://user-images.githubusercontent.com/80289154/206309015-a8600bc4-6a0f-4646-b922-4eb9b4380a8d.png)

![image](https://user-images.githubusercontent.com/80289154/206309056-9375ce44-e980-4b73-8529-a602f2d54aaf.png)

- Attribuer à cet utilisateur un mot de passe 

![image](https://user-images.githubusercontent.com/80289154/206309164-c7adb94a-6eec-45ec-9c2e-abeb090fe478.png)

![image](https://user-images.githubusercontent.com/80289154/206309197-47924b41-3a8f-4063-8bfc-37e946032368.png)

- Créer un 2ème utilisateur => même façon

![image](https://user-images.githubusercontent.com/80289154/206309325-782522de-7444-413a-a276-f14d95c8fb04.png)

- Créer des rôles : ADMIN et USER

![image](https://user-images.githubusercontent.com/80289154/206309460-2f208c5b-7fd5-4739-ba4f-54240c8502b3.png)

- Affecter les rôles aux utilisateurs 

![image](https://user-images.githubusercontent.com/80289154/206309504-b935345b-ebf5-410d-82b1-d0c422f066a8.png)

- User1 = USER 

![image](https://user-images.githubusercontent.com/80289154/206309575-84c7db07-c49c-4888-9f34-cc4d363aab59.png)

- User2 = USER + ADMIN

![image](https://user-images.githubusercontent.com/80289154/206309625-c970434e-722f-4d46-a1ae-32343a298d04.png)

- Tester les différents modes d'authentification avec Postman en montrant les contenus de Access_Token, Refresh_Token :
      - Test d’authentification :
Pour s’authentifier, supposons qu’il s’agit d’une application mobile 
Dans une application mobile on ne peut pas faire des redirections vers keycloak, c’est à nous qu’on doit créer notre propre formulaire et c’est à partir de cet formulaire on va envoyer une requête à keycloak (username+mdp), et il va nous donner le id_token.

URL : realm setting

![image](https://user-images.githubusercontent.com/80289154/206309856-6b9c8357-bc29-4c04-b3d0-cf2eef9abf21.png)

![image](https://user-images.githubusercontent.com/80289154/206309874-938af746-7ecf-4762-a419-db6a7325ed01.png)

Postman :

![image](https://user-images.githubusercontent.com/80289154/206309985-2728d7c4-6e16-4e14-9ddb-449835136b9f.png)

- Récupérer le id_token après l’envoi de la requête 

![image](https://user-images.githubusercontent.com/80289154/206310120-94d42c68-dc5d-4e5c-82d8-c0400aad5bd4.png)
    
   => Access_tocken => objet Json jwt 
   
![image](https://user-images.githubusercontent.com/80289154/206310257-bdbc2542-41da-46a2-aae9-f3fd6d769367.png)

![image](https://user-images.githubusercontent.com/80289154/206310282-85b1c8e5-25d0-469d-a691-8edb5f189e32.png)

![image](https://user-images.githubusercontent.com/80289154/206310315-e8f7fcc0-4e28-460b-80eb-232483c2ed63.png)

- Demander un autre access_token 
    - S’authentifier mais avec refresh _token pour avoir un nouveau access _token 

![image](https://user-images.githubusercontent.com/80289154/206310415-dda7fab5-4379-459c-8c3c-1ba4a5864551.png)

 => 3 méthodes pour s’authentifier : 
1/ s’authentifier via un mot de passe
2/ s’authentifier via un refresh_token tant qu’il n’est pas encore expiré
3/ s’authentifier en utilisant Client_ID et client secret 

- S’authentifier en utilisant Client_ID et client secret 

![image](https://user-images.githubusercontent.com/80289154/206310575-9315ed06-ced8-4e2e-8b71-31af8939f7d8.png)

   => Authentifier l’app et non pas le user, donc l’app doit envoyer un client id et client secret
   => Ceci est utile pour les apps backend et non pas les apps frontend 
   
![image](https://user-images.githubusercontent.com/80289154/206310700-992dd890-007f-4aae-b9a8-3c961b6e37fc.png)

![image](https://user-images.githubusercontent.com/80289154/206310726-5dcd5732-c23a-445c-9d04-540715f05705.png)

- On aura un access token avec longue durée sans refresh token

![image](https://user-images.githubusercontent.com/80289154/206310846-df12262a-f058-40cc-bc1b-413460f6ca55.png)

- Error => on doit désactiver le secret client

![image](https://user-images.githubusercontent.com/80289154/206310951-d6927846-6d6a-48f0-85b0-d997931e3720.png)

![image](https://user-images.githubusercontent.com/80289154/206310967-eb0f8b68-7dbc-4149-b03e-608a8b82df35.png)

![image](https://user-images.githubusercontent.com/80289154/206310980-a0fcb024-a986-4cb2-947e-c085f6040549.png)


 











  
  














