pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         booleanParam(name: 'dev', defaultValue: true, description: 'What should I say?')
     }
    stages {
        stage('build hadiya'){
            steps{
                build 'BuildDeneme2'
            }
        }
        stage('build') {

            when{
                allOf{
                    expression { params.dev == true }
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
