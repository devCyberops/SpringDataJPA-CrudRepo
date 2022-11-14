pipeline{
    agent any
    tools {
        maven 'M2_HOME'
    }
    stages {
        stage('Getting project from Git') {
            steps{
      			checkout([$class: 'GitSCM', branches: [[name: '*/insaf']],
			extensions: [],
			userRemoteConfigs: [[url: 'https://github.com/devCyberops/SpringDataJPA-CrudRepo.git']]])
            }
        }



        stage('Cleaning the project') {
            steps{
                	sh "mvn -B -DskipTests clean  "
            }
        }



        stage('Artifact Construction') {
            steps{
                	sh "mvn -B -DskipTests package "
            }
        }



         stage('Unit Tests') {
            steps{
               		 sh "mvn test "
            }
        }



        stage('Code Quality Check via SonarQube') {
            steps{

             		sh "mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://192.168.1.3:9000 -Dsonar.login=4a6c5ee5dfe730fe7a38cb3c96f13f4811aa1fe1"

            }
        }


        stage('Publish to Nexus') {
            steps {


  sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.rh -DartifactId=achat -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.3:8081/repository/maven-releases/ -Dfile=target/achat-1.0.jar'


            }
        }
	    stage("Email"){
           steps{
               emailext attachLog: true, body: "SUCCESS PUBLISH :  ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'insaf.elinkichari@esprit.tn'
           }
       } 

stage('Build Docker Image') {
                      steps {
                          script {
                            sh 'docker build -t insaf921999/alpine:latest .'
                          }
                      }
                  }

                  stage('login dockerhub') {
                                        steps {
                                      sh 'docker login -u insaf921999 -p Djerb@tunis1'
                                            }
		  }
	    
	                      stage('Push Docker Image') {
                                        steps {
                                   sh 'docker push insaf921999/alpine:latest '
                                            }
		  }


		   stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up -d'
                                    }
                                }
                            }

	    



     
}

	    
    

    
	
}
