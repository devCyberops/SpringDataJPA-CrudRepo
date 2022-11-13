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

      

        stage('MVN CLEAN'){
            steps{
                sh  'mvn clean'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN PACKAGE'){
              steps{
                  sh  'mvn package'
              }
        }
              stage("nexus deploy"){
               steps{
                       sh 'mvn  deploy'
               }
          }

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

          stage('MVN SONARQUBE'){

                steps{
                          sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=Bouby2022'
                }
          }

      }
}
