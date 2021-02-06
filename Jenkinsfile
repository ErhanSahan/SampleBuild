pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         booleanParam(name: 'dev', defaultValue: true, description: 'What should I say?')
     }
    stages {
        stage('build') {
            steps{
                build job: 'hadiya', parameters: [booleanParam(name: 'dev', value: true)]
            }
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
