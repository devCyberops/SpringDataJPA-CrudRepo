pipeline{
    
    agent any
    
     tools {
    maven 'M2_HOME'
    }
    
 stages{
    
    stage('Git') {
        
        steps('Cloning'){
            
        git branch: 'zied', url: 'https://github.com/devCyberops/SpringDataJPA-CrudRepo'
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
     stage('Maven Install') {
        steps('Install') { 
        
          sh 'mvn install'
     
        }  
    }
    
    stage('SonarQube') { 
        
        steps{
            
            sh 'mvn sonar:sonar -Dsonar.login=79a65f38eb97721b534c3360dc83e0f3bf042f63'
        }
    
    }
        
    stage ('Junit + Mockito') {
        
        steps{
            
            sh 'mvn test'
        }
        
    } 
    
     /*stage("nexus deploy"){
        
        steps{
            
            sh 'mvn clean deploy -DskipTests'
            sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
             
            }
    }*/
     
    stage('Docker Build') {
    	agent any
    	
        steps {
            
      	sh 'docker build -t '
      	
      	 withDockerRegistry([credentialsId: "Docker-Hub-milqshake", url: ""]) {
            sh 'docker push'
        }
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
}
