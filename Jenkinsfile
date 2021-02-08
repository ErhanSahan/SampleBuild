
pipeline {
    agent any
    tools{
     maven 'maven'  
    }
      parameters {
         booleanParam(name: 'call', defaultValue: true, description: 'What should I say?')
         booleanParam(name: 'call2', defaultValue: true, description: 'What should I say?')
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
                    cd Development
                    ls
                    mvn clean install
                    """
                }
            }
        }
        stage('push'){
            steps{            
                sh"""
                #!/bin/bash
                git config --global user.email "erhan_sahan987@hotmail.com"
                git config --global user.name "ErhanSahan"
                git add .
                git commit -m "Add existing file"
                git push origin development
                """
            }
        }
    }
}
