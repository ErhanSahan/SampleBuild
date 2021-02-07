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
                build job: 'call', parameters: [booleanParam(name: 'Version', value: true), string(name: 'DEPLOY_ENV', value: '5.3')]
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
