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
    
    /*stage('SonarQube') { 
        
        steps{
            
            sh 'mvn sonar:sonar -Dsonar.login=bca9996621cff432c68644699c1e52765c050f99'
        }
    
    }*/
    
     /*stage("nexus deploy"){
        
        steps{
            
            sh 'mvn clean deploy -DskipTests'
            
             
            }
    }*/
     
    stage('Docker Build') {
    	agent any
    	
        steps {
            
      	sh 'docker build -t test:1 .'
      	
            sh 'docker push test:1'
        
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

