pipeline{
    
    agent any
    
     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
    
      environment { 
       DOCKERHUB_CREDENTIALS = credentials('docker-hub')
    }
    
 stages{
    
    stage('Git') {
        
        steps('Cloning'){
            
        git branch : 'zied',
                // Get some code from a GitHub repository
                url: 'https://github.com/devCyberops/SpringDataJPA-CrudRepo.git'

                // Get System Current Date
                script{
                    Date date = new Date()
                    String dateString = date.format("dd-MM-yyyy")
                    println "Date : " + dateString
                }
        }
    }
        
    stage('Maven Check') { 
        steps('Check Version') {
            
        sh 'mvn -version'
     
        }
    }
    stage('Maven Compile') {
    
        steps('Compile Code') { 
       
        sh 'mvn clean'
        sh 'mvn compile'
     
        }
    }
     /*stage('Maven Install') {
        steps('Install') { 
        
          sh 'mvn install'
     
        }  
    }*/
    
       
    stage ('Junit + Mockito') {
        
        steps{
            
            sh 'mvn test'
        }
        
    } 
    
    stage("Maven Build") {
            steps {
                script {
                    sh 'mvn package -DskipTests=true'
                }
            }
        }

    
    stage ('SonarQube') { 
        
        steps{
                sh 'mvn sonar:sonar \
  -Dsonar.projectKey=com.esprit.examen:tpAchatProject \
  -Dsonar.host.url=http://192.168.1.17:9000 \
  -Dsonar.login=77c549ecbe09411c0d284e027174bdf2f607348b'      
                            
                      
                    
            }
        
 		    
        
    
    }
    
     /*stage("nexus deploy"){
        
        steps{
            
            sh 'mvn clean deploy -DskipTests'
            
             
            }
    }*/
     
   stage('Building Docker image') { 
            steps { 
               sh 'docker build -t milqshake/tpachat .'
}
            } 
     
     
      stage('Trivy Scan') {
            steps {
                script {
			
			sh "trivy image -f json -o results.json milqshake/tpachat"
                recordIssues(tools: [trivy(pattern: 'results.json')])
                }
                
            }
        }

        
           stage('login to dockerhub') {
            steps{
               
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p ******'
            }
           }
           
        stage('Push Docker image') { 
            steps { 
                sh 'docker push milqshake/tpachat:latest'
}

            
        } 
    
    stage('Docker-compose up') {
        
        steps {
            
        sh "docker-compose up -d"
       
        
        }
    }

    /* stage('Cleaning up') { 
        steps { 
            sh "docker rmi $registry:$BUILD_NUMBER" 
        }
    }*/


}

post {
            success {
                mail body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}",
                to: "zied.selmi@esprit.tn",
                subject: "Pipeline Success"  
            }
            failure {
                mail body: "Job has failed${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}", 
                to: "zied.selmi@esprit.tn",
                subject: 'Pipeline fail'
            }
    }

}



