pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         booleanParam(name: 'call', defaultValue: true, description: 'What should I say?')
         booleanParam(name: 'call2', defaultValue: true, description: 'What should I say?')
     }
    stages {
        stage('build call'){
             when{
                expression{params.call == true}
            }
            steps{
                build job: 'call', parameters: [booleanParam(name: 'Version', value: true), string(name: 'DEPLOY_ENV', value: '5.3')]
            }
        }
        stage('build call2'){
            when{
                expression{params.call2 == true}
            }
            steps{
                build job: 'call2', parameters: [booleanParam(name: 'Version', value: true), string(name: 'DEPLOY_ENV', value: '5.3')]
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
