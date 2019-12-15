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
        def antHome = tool name: 'ant1', type: 'ant'
        sh "${antHome}/bin ant -d build"
    }
    stage("Cleanup") {
        cleanWs()
    }
}
