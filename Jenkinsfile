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
            
            sh 'mvn sonar:sonar -Dsonar.login=93119ee3376d747389d2d527d09567cade5a3c44"'
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

    
