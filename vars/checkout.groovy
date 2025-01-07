def call(String gitbranch, String repourl, String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    def scmConfig= [
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ]
    checkout scm: scmConfig
}

