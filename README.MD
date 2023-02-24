Mini Projet Jenkins
----------------------

ce qu'il faut faire : Mettre en place une pipilien CI/CD avec test de l'artefact pour une mise en REVIEW puis en STAGING puis enfin en PRODUCTION.

 ![image](https://user-images.githubusercontent.com/88394820/221151523-14c20e4c-0ae0-435c-ae52-32aa86db2027.png)


----------------------

Premièrement, j'ai créé un fork du projet git https://github.com/diranetafen/static-website-example.git 

![image](https://user-images.githubusercontent.com/88394820/221151305-c994d580-5d37-4419-9256-63cf61ac3768.png)


Par la suite, j'ai utilisé mon Jenkins depuis ma VM Debian.
Jenkins a été installé via un docker-compose fournie par Easytranning.

Sur Jenkins, je vais metter en place une Pipeline

![image](https://user-images.githubusercontent.com/88394820/221154152-08113f28-e9f4-44d9-a9d1-9cdda9b58bc7.png)

Sur celle-ci j'ai configuré le GitHub project ainsi qu'une variable String Parameter que j'utiliserai dans mon script Jenkinsfile.

![image](https://user-images.githubusercontent.com/88394820/221202283-06fbc42a-13b2-4371-a084-9a2e6764f62a.png)
GitHub hook trigger for GITScm polling est activé.
![image](https://user-images.githubusercontent.com/88394820/221202810-23816c69-40ae-4011-a634-3574d48c1fb3.png)

Dans la partie Pipeline, j'ai renseigné le répo GIT.

![image](https://user-images.githubusercontent.com/88394820/221203032-d3f20e3d-a663-4123-a52f-6e6510b7cec8.png)

Enfin, j'ai saisie le nom du script Jenkinsfile.

![image](https://user-images.githubusercontent.com/88394820/221203235-c98f58ac-6c26-45a2-a009-319aff19c8cd.png)


Sur le répo GIT, j'ai configuré la partie Webhook

![image](https://user-images.githubusercontent.com/88394820/221201530-cac83284-c433-45a8-943b-8715bcfe53c2.png)

