pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         booleanParam(name: 'call', defaultValue: true, description: 'Call job?')
         booleanParam(name: 'call2', defaultValue: true, description: 'Call job2?')
         string(name: 'version', defaultValue: '', description: 'Version')

     }
    stages {
        stage('checkout'){
            when{
                expression{params.version!=''}
            }
            steps{
                sh"""
                #!/bin/bash
                rm -rf *
                git checkout development
                cd Development
                mvn versions:set -DnewVersion=1.0.3-SNAPSHOT
                """
            }
        }
        stage('build call'){
             when{
                expression{params.call == true}
            }
            steps{
                build job: 'call', parameters: [booleanParam(name: 'Version', value: true), string(name: 'DEPLOY_ENV', value: params.version)]
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
            steps {
                script{
                    sh """
                    ls
                    cat README.md
                    cd Development
                    ls
                    mvn clean install
                    """
                }
            }
        }
        stage('push'){
            when{
                expression{params.version!=''}
            }
            steps{            
                sh"""
                #!/bin/bash
                git add .
                git commit -m "Add existing file"
                """
            }
        }
    }
}
