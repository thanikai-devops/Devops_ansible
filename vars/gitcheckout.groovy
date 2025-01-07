def call(String gitbranch , String repourl,String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    def gitBranch = System.getenv('GIT_BRANCH') ?: error('GIT_BRANCH environment variable must be provided')
    def gitUrl = System.getenv('GIT_URL') ?: error('GIT_URL environment variable must be provided')
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}

