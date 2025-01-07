def call(String gitbranch , String repourl,String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    gitbranch = gitbranch ?: System.getenv('GIT_BRANCH') ?: error("Branch must be provided")
    repourl = repourl ?: System.getenv('REPO_URL') ?: error("Repository URL must be provided")
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}

