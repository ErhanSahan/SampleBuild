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
                cd 
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
        stage('checkout'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5a91e258-8aeb-43f9-84c7-bae3e933415d', url: 'https://github.com/ErhanSahan/build.git']]])
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
                git add .
                git commit -m "Add existing file"
                git push origin development
                """
            }
        }
    }
}
