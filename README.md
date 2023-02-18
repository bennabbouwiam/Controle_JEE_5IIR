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

### Partie 9 : Sécuriser les micro-services et le frontend angular en déployant les adaptateurs Keycloak

-	Préparer l’environnement Keycloak :
  -	Démarrer keycloak avec la comande "kc.bat start-dev"
  -	Accéder à la console d’administration après la création d’un administrateur
  - Créer un realm qui va comporter les applications à sécuriser, les users, les rôles …

![image](https://user-images.githubusercontent.com/80289154/206784102-87827083-95a7-4f5e-ab99-99205b65dc8d.png)

•	Créer les clients : les applications à sécuriser

![image](https://user-images.githubusercontent.com/80289154/206784154-45884508-9617-4403-91de-3f16d8b0da00.png)

![image](https://user-images.githubusercontent.com/80289154/206784215-d6d64d54-ced5-477a-aab5-895bf4f59be6.png)

•	Créer les users et les attribuer des mots de passe permanents et non pas temporaires

![image](https://user-images.githubusercontent.com/80289154/206784253-d2249580-7887-41a7-ac17-c6258818e4df.png)

•	 Créer les rôles 

![image](https://user-images.githubusercontent.com/80289154/206784323-aa5008c8-d887-4f12-be05-d3e8ceb05d31.png)

•	Affecter les rôles aux utilisateurs
              User1 => USER
              User2 => ADMIN+USER
              User3 => ADMIN+USER+MANAGER

-	Tester avec Postman

![image](https://user-images.githubusercontent.com/80289154/206784392-a72fa557-6357-4660-94df-a00972cc94db.png)

•	1ère méthode de s’authentification : s’authentifier avec un mot de passe et récupérer l’access token
      Access_token => reste un objet jwt 
      
![image](https://user-images.githubusercontent.com/80289154/206784518-3556d312-09da-4ae3-9173-14f1bb3f21d8.png)

       => Access_token : reste un objet jwt  

![image](https://user-images.githubusercontent.com/80289154/206784626-291090a6-7b8c-4444-b070-6bd594f0a822.png)

![image](https://user-images.githubusercontent.com/80289154/206784651-0aa32f04-f1b4-4cb4-8d45-c8a6909dec70.png)

-	Changer les paramètres d’expiration de token : "Access token lifespan 10"

![image](https://user-images.githubusercontent.com/80289154/206784736-8cc8b522-2857-434f-b71e-4d3f149e87b8.png)

![image](https://user-images.githubusercontent.com/80289154/206784754-23c0ed5f-2af1-49ae-94dc-a446448845b1.png)

-	Verification avec user2

![image](https://user-images.githubusercontent.com/80289154/206784798-6a606831-52ce-4965-96e4-1f1cacc9e835.png)

![image](https://user-images.githubusercontent.com/80289154/206784826-9a33b1d9-ef43-43df-bfdc-a5b8453d84ee.png)

•	2ème méthode d’authentification : s’authentifier avec refresh_token

![image](https://user-images.githubusercontent.com/80289154/206784886-a3a7d945-ea8d-48c1-ad7b-ff1d8331ee68.png)

![image](https://user-images.githubusercontent.com/80289154/206784907-9a368d50-dc06-46fc-94d8-4c547b9bc52a.png)

-	Sécuriser le 1er micro service des produits 

![image](https://user-images.githubusercontent.com/80289154/206784952-f6598647-ea07-401d-ba75-3d9fd2adbf85.png)

•	Exécution : la liste des produits 

![image](https://user-images.githubusercontent.com/80289154/206784990-f311019a-045b-4d8d-b697-e8e4d1d3dca9.png)

-	Ajouter les dépendances : spring security + adaptateur keycloak keycloak-spring-boot-starter
-	Créer la configuration keycloak : @KeycloakConfiguration
-	Fichier de configuration properties : ajuster les paramètres de configuration pour adapter keycloak 
-	Adapter cherche toujours le fichier keycloak.json pour les paramètres de configuration, c’est pour cela qu’on va créer 
  une classe de configuration pour ne pas avoir cet changement et prendre en compte la configuration qui se trouve dans le fichier properties
-	Après la configuration on accède aux produits et voilà le résultat :

![image](https://user-images.githubusercontent.com/80289154/206785086-0aeda8f5-717a-4645-ad47-36ca1d19939b.png)

![image](https://user-images.githubusercontent.com/80289154/206785108-ba54fef0-bd2f-4628-b93f-a8579b961be5.png)

•	Une fois authentifié on peut accéder à la liste des produits

![image](https://user-images.githubusercontent.com/80289154/206785155-06c55702-7262-46c6-8db9-fa48a776f226.png)

•	On veut afficher par défaut une fois authentifié le username, c’est pour cela qu’on doit ajuster et ajouter 
  quelques paramètres de configuration dans le fichier properties
  
  ![image](https://user-images.githubusercontent.com/80289154/206785227-2114ce74-3e85-486c-b12c-c93e279eb07c.png)

-	Sécuriser le 2ème micro service des fournisseurs

•	Les mêmes classes de configuration (package sec)

![image](https://user-images.githubusercontent.com/80289154/206785278-761c4e70-e967-4f78-9bd5-377d2d22bb8f.png)

•	Pour générer le token, keycloak va utiliser public key, c’est pour cela qu’il faut ajouter des paramètres 
  de configuration dans le fichier applicationProperties
  
  ![image](https://user-images.githubusercontent.com/80289154/206785324-7d6df07e-cd28-441a-a759-196cb597513f.png)

  •	Le JWT
  
  ![image](https://user-images.githubusercontent.com/80289154/206785366-feaed4e9-29b3-42cd-a249-e11036a74f3d.png)

  •	Pour qu’un micro service peut communiquer avec un autre, il doit envoyer le token à l’utilisateur
  
  ![image](https://user-images.githubusercontent.com/80289154/206785417-a104d5b3-7bc5-4d6b-901e-c70050205284.png)

  •	Accéder à la liste des fournisseurs 
  
  ![image](https://user-images.githubusercontent.com/80289154/206785464-ca0f3340-637d-4ee2-a425-e944a58433f7.png)

  ![image](https://user-images.githubusercontent.com/80289154/206785494-f44c0d4f-114b-4827-9de3-447d4f5dc037.png)
  
  
  ------------------------------------------------------------------------------------------------------
  # Partie Kafka : Event Driven Architecture avec KAFKA et Spring Cloud Streams
  ## Enoncé 
  
1. Intégration du Bocker KAFKA
2. Création d'un micro-service qui permet de produire aléatoirement des factures et de les publier dans un Topic KAFKA
3. Permettre au Micro-service déjà développé BILLING-SERVICE de consommer les factures publier dans le Topic KAFKA et de les enregistrer dans sa base de données
4. Créer un micro-service Data-Analytics-Service qui utilise l'API KAFKA Streams pour effectuer du Real Time Stream Processing en consommant le streams de facture publiées dans le Topic KAFKA
5. Créer une Page Frontend qui permet de présenter en temps réel les courbes qui montrent les résultats produits par le service du Data Analytics
6. Déployer l'ensemble des services de l'application en utilisant des conteneur Docker : Créer les images Docker pour chaque service et et le fichier Docker-compose.yml qui permet de déployer toute l'application

## Architecture version finale 

![image](https://user-images.githubusercontent.com/80289154/219857184-996b033a-daa7-4537-9c56-2625d0b5672d.png)

![image](https://user-images.githubusercontent.com/80289154/219857322-d397d046-e40e-4647-b2c4-f19f5a23797b.png)

- téléchargement de kafka 

![image](https://user-images.githubusercontent.com/80289154/219857348-377abaea-5bc7-46dd-a37f-75aed443a4ba.png)

![image](https://user-images.githubusercontent.com/80289154/219857358-e354b18f-f849-4047-b7e9-c60e871635be.png)

- Démarrer Zookeeper

- Démarrer Kafka-server

- Tester avec Kefka-console-producer et kafka-console-consumer

=> Lancer le serveur Zookeeper :

> bin\windows\zookeeper-server-start.bat config/zookeeper.properties

![image](https://user-images.githubusercontent.com/80289154/219857474-6fdb7824-557f-45d8-922f-1bc10f1f8b05.png)

=> Lancer le Broker KAFKA : 

> bin\windows\kafka-server-start.bat config/server.properties

![image](https://user-images.githubusercontent.com/80289154/219857493-d87d4694-50e7-4b23-871e-c503e0626cf9.png)

- Tester avec Kafka-console-producer et kafka-console-consumer

=> lancer kafka-console-consumer : 

> start bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic R1

![image](https://user-images.githubusercontent.com/80289154/219857513-1fcbe9fb-ff11-4cfe-b741-689c0097be3f.png)

=> lancer kafka-console-producer : 

> start bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic R1

![image](https://user-images.githubusercontent.com/80289154/219857540-35aceea3-e524-4637-8c28-2e016d24593a.png)

->  Testing 

![image](https://user-images.githubusercontent.com/80289154/219857563-8e8dddd6-bff6-4dff-af8d-4b5aa3c91fa9.png)

- Réaliser ue application qui permet de gérer les événements qui se produisent dans des pages à travers Spring cloud streams 

- Créer la classe PageEvent : 

- Créer un Rest Controller pour envoyer et publier des messages dans topic kafka suite à un évenement qui va se produire dans l’interface web de l’app (UI)

Pour pouvoir publier des messages dans topic kafka, il existe 3 méthodes :
 
       -> utiliser kafka template (@kafkaListener)
       
       -> utiliser spring cloud streams (message channel @streamListener)
       
       -> utiliser spring cloud streams functions

=> Tester 

![image](https://user-images.githubusercontent.com/80289154/219857707-9938d5dc-f42b-4aae-a69f-00ec597a1b27.png)

![image](https://user-images.githubusercontent.com/80289154/219857716-9bb6be83-b5af-4806-b7aa-8beb11ab589e.png)

- 2ème cas : 

Au lieu d’avoir un consumer créé à partir du cmd, au lieu de consommer le message en utilisant kafka console, on va créer une app consumer qui va écouter le topic R1 et de lire ces messages et les afficher dans l’app. 

-> Pour créer un consumer : soit en utilisant l’annotation @MessageListener qui est définie sur SpringCloudStream
->	Soit en exploitant la programmation fonctionnelle

Pour se faire : on va créer un service avec l’annotation @Service => créer une fonction avec l’annotation @Bean qui va retourner un consumer qui va consommer des objets de type EventPage

Pour que tout cela fonctionne, par défaut SpringCloudStream va avoir un topic qui porte le même nom du bean généré (de la fonction) (de la page) => il faut aller au fichier de configuration properties (configurer le nom du topic) : 

    #nom du topic par défaut 
    
    #pageEventConsumer-in-0

Si on ne veut pas un nom par défaut on doit le configurer (faire de binding ou de la correspondance) dans le fichier en utilisant : 

    spring.cloud.stream.bindings.pageEventConsumer-in-0.destination=R1
    
Le nom est R1 du topic

Résumé : pour déployer un consommateur, on crée un service qui comporte une fonction qui va retourner un consumer qui attend le message en input et sui consomme des objets de type EventPage

=> Tester 

![image](https://user-images.githubusercontent.com/80289154/219857889-d617b0e6-8f20-4595-adc8-aa2660ca89eb.png)

![image](https://user-images.githubusercontent.com/80289154/219857898-619b3050-ca57-45d7-a1c3-84ef3c7da33f.png)

- 3ème cas : créer un ProducerPoller

Créer un fournisseur de données qui va produire des messages dans topic R2, pour chaque seconde on va envoyer des messages vers topic kafka => ajouter une fonction qui retourne un supplier 

R1 : test

![image](https://user-images.githubusercontent.com/80289154/219857952-1d949598-5ffc-46b4-be0d-ed85d9f49ca3.png)

R2 : test => Lancer un consumer 

![image](https://user-images.githubusercontent.com/80289154/219857973-ab79c19e-1fa7-4c0a-b8b3-0badd8a7424e.png)

On peut régler le temps de pull de message 

![image](https://user-images.githubusercontent.com/80289154/219857989-1c254e37-a2a3-48be-8853-fade5b244b18.png)

Un flux de données qui arrivent : 

Si on veut analyser ce flux de données en temps réel = traitement de type batch

Framework spring batch (traitement par lot)

Traiter les données en temps réel pour prendre des décisions, c’est du stream processing = Kafka streams 

- 4ème cas : consumer&Producer 

	Une app dans laquelle on va recevoir un flux en input, l’app va le traiter, et va produire un autre Stream en output qui va vers un autre topic 
 
	Lire sur -> R2 et Produire en output sur R3 
 
Ça se passe toujours sur la classe @service (traitement)

=> Tester : Lancer un consumer sur topic R3

![image](https://user-images.githubusercontent.com/80289154/219858121-a847f60f-254c-4cb4-aea1-82d902fd7ec7.png)

Produire sur R1 avec RestController => lire de R1 (input sur R1) et output sur R3

![image](https://user-images.githubusercontent.com/80289154/219858141-9d884b14-66d9-4b6f-9977-abb068fe4e33.png)

![image](https://user-images.githubusercontent.com/80289154/219858150-a13a3436-8ef4-4f8c-b514-84f720d31a1e.png)

Produire sur R2 avec SupplierPoller => lire de R2 (input sur R2) et output sur R3

![image](https://user-images.githubusercontent.com/80289154/219858166-ad111c0e-b08e-4943-b417-80e1de3d854d.png)

- 5ème cas : kafka Streams

Traitement de données en temps réel = traitement côté client 

Steam processing = pas de traitement distribué (cluster distribué) = avoir besoin d’une API légère capable de faire des traitements rapidement

Bach processing # stream processing 

Principe technique : ajouter une fonction dans le service qui va recevoir en input un Stream, lire les données qui sont produites dans le topic R2

=> recevoir un flux d’enregistrement (data record : clé/value) dans la topic R2 (le topic dont lequel on va consommer les données), et produire un output un autre flux

d’enregistrements qui contient les statistiques = KTable

Lire de R2 et output sur R4

=> Tester 

![image](https://user-images.githubusercontent.com/80289154/219861697-c996c3ee-990e-4042-a6a0-7ff2fa72bdad.png)

Lancer un consumer dans R4 pour voir la sortie : 

![image](https://user-images.githubusercontent.com/80289154/219862139-d05deeeb-4610-49d1-94a4-14b2a1d576d9.png)

![image](https://user-images.githubusercontent.com/80289154/219862566-ae380524-9224-4174-b3ed-e7885290e368.png)

Résultat final :

![image](https://user-images.githubusercontent.com/80289154/219862902-e076fa2b-7b36-4b25-9a9f-ac10b4737d37.png)

![image](https://user-images.githubusercontent.com/80289154/219863003-6c56c1a5-521a-42c5-8e88-850118f9a40d.png)

 



















  
  






 











  
  














