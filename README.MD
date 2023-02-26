Mini Projet Jenkins
----------------------

ce qu'il faut faire : Mettre en place une pipilien CI/CD avec test de l'artefact pour une mise en STAGING puis enfin en PRODUCTION.

 ![image](https://user-images.githubusercontent.com/88394820/221151523-14c20e4c-0ae0-435c-ae52-32aa86db2027.png)

Nous allons utiliser la plateforme EasyLab pour le Staging et la Production : https://github.com/eazytraining/eazylabs.git

Premièrement, j'ai créé un fork du projet git https://github.com/diranetafen/static-website-example.git 

![image](https://user-images.githubusercontent.com/88394820/221151305-c994d580-5d37-4419-9256-63cf61ac3768.png)


Par la suite, j'ai utilisé mon Jenkins depuis ma VM Debian.
Jenkins a été installé via un docker-compose fournie par eazytraining.

Sur Jenkins, je vais metter en place une Pipeline.

![image](https://user-images.githubusercontent.com/88394820/221154152-08113f28-e9f4-44d9-a9d1-9cdda9b58bc7.png)

Sur celle-ci, j'ai configuré le GitHub project ainsi qu'une variable String Parameter que j'utiliserai dans mon script Jenkinsfile.

![image](https://user-images.githubusercontent.com/88394820/221402392-6315382f-e2a0-401a-b874-fca42e8d8676.png)
GitHub hook trigger for GITScm polling est activé.
![image](https://user-images.githubusercontent.com/88394820/221202810-23816c69-40ae-4011-a634-3574d48c1fb3.png)

Dans la partie Pipeline, j'ai renseigné le répo GIT.

![image](https://user-images.githubusercontent.com/88394820/221203032-d3f20e3d-a663-4123-a52f-6e6510b7cec8.png)

Enfin, j'ai saisie le nom du script Jenkinsfile.

![image](https://user-images.githubusercontent.com/88394820/221203235-c98f58ac-6c26-45a2-a009-319aff19c8cd.png)

Pour les secrets, j'en ai créé 2 permettant de me connecter au DockerHub (pour pouvoir pusher mon image) puis un autre pour les notification Slack (intégration de la thread ![image](https://user-images.githubusercontent.com/88394820/221222337-6338ee40-6c8a-4a42-aa71-1f8170b7ba43.png) )

![image](https://user-images.githubusercontent.com/88394820/221222187-a2723214-aecc-4906-865d-abda49a9a541.png)


Sur le répo GIT, j'ai configuré la partie Webhook (j'utilise Nrok pour exposer mon jenkins local sur Internet)

![image](https://user-images.githubusercontent.com/88394820/221201530-cac83284-c433-45a8-943b-8715bcfe53c2.png)


Notification : 

![image](https://user-images.githubusercontent.com/88394820/221224036-6644d329-ef7f-44bf-a613-84ad03cc86b4.png)

Sur Jenkins : 
https://github.com/tonytdj/shared-library

Le répo GIT au sujet des notif : https://github.com/tonytdj/shared-library

![image](https://user-images.githubusercontent.com/88394820/221225299-dbff5e02-e1ff-4ece-b989-6e1ba3aef8a0.png)

Après pusieurs test, la pipeline est fonctionnelle : 

![image](https://user-images.githubusercontent.com/88394820/221225628-1df3440b-7cee-4723-9768-63bd35818a81.png)

Sur la Staging : 
![image](https://user-images.githubusercontent.com/88394820/221229539-3a159d73-3ee3-452e-b3b4-e64f685830ad.png)

Sur la prod : 
![image](https://user-images.githubusercontent.com/88394820/221225158-462bfcd7-8a18-468c-b07f-4034e8ec211e.png)

Sur Docker Hub : 
On voit bien l'image qui a été pushé
![image](https://user-images.githubusercontent.com/88394820/221238140-28491a48-daa4-462d-bb7c-d0a737012170.png)

