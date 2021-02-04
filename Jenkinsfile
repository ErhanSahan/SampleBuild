pipeline {
    agent any 
    checkout([$class: 'GitSCM', branches: [[name: '*/main']],doGenerateSubmoduleConfigurations: false, extensions: [],submoduleCfg: [], userRemoteConfigs:
              [
                  [credentialsId: '5a91e258-8aeb-43f9-84c7-bae3e933415d', url: 'https://github.com/ErhanSahan/build.git']
              ]
             ]
            )
    stages {
        stage('Stage 1') {
            steps {
                sh """
                cd Development
                mvn clean deploy
                """
            }
        }
    }
}
