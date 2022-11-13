pipeline {
    agent any

	environment {
            registry = "cartoure/devops-project"
            registryCredential = 'cartoure-dockerhub'
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
	 
	stage('MVN SonarQube'){

                steps{
                          sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Bouby2022'
                }
          }
              //stage("NEXUS DEPLOY"){
               //steps{
                 //      sh 'mvn  deploy'
               //}
          //}

	stage('Building our image') {
               steps{
                        script {
                            dockerImage = docker.build registry + ":latest"
                        }
               }
        }

         stage('Deploy our image') {
               steps {
                        script {
                            docker.withRegistry( '', registryCredential ) {
                                dockerImage.push()
                            }
                        }
               }
         }

          stage('DOCKER COMPOSE') {
                steps {
                            sh 'docker-compose up -d --build'
                }
          }

          

      }
}
