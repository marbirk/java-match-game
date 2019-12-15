#!groovy

node {
    stage("Cleanup") {
        cleanWs()
    }
    stage("Checkout") {
        checkout([
                $class: 'GitSCM', 
                branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [], 
                submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/marbirk/java-match-game']]
        ])
    }
    stage("Build") {
        def mvn_version = 'M2'
        withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) {
            sh "mvn package"
        }
    }
    stage("Cleanup") {
        cleanWs()
    }
}
