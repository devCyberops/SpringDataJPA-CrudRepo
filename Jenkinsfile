pipeline {
    agent any

	environment {
            registry = "cartoure/devops-projects"
            registryCredential = 'devops-dockerhub'
            dockerImage = ''
     }

 stages {

        stage('Checkout GIT') {
            steps {
                echo 'Pulling...';
                git branch: 'toure',
                url : 'https://github.com/devCyberops/SpringDataJPA-CrudRepo.git'
            }
        }

      

        stage('MVN Clean'){
            steps{
                sh  'mvn clean'
            }
        }

        stage('MVN Compile'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN Package'){
              steps{
                  sh  'mvn package'
              }
        }

	stage('MVN Install'){
              steps{
                  sh  'mvn install'
              }
        }
	 
	stage('MVN SonarQube'){

                steps{
                          sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Bouby2022'
                }
          }
              /*stage("Nexus push"){
               steps{
                       sh 'mvn  deploy'
               }
          }*/

	stage('Build image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":latest"
                        }
               }
        }

         stage('Deploy image') {
               steps {
                        script {
                            docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
               }
         }

	stage('Junit / Mockito') {
      		steps {
        		sh 'mvn test'
      				}
    			}

   

         /* stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d --build'
                }
          }*/
	 

          

      }
}
