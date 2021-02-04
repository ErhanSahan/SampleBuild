pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         boolean(name: 'dev', defaultValue: true; description: 'What should I say?')
     }
    stages {
        stage('build') {
            when{
                all of{
                    params.dev == true             
                }
            }
            steps {
                script{
                    sh """
                    ls
                    cd Development
                    ls
                    mvn clean install
                    """
                }
            }
        }
    }
}
