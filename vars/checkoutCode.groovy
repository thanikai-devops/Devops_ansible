def call(String gitbranch="" , String repourl="",String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}

