def call(String gitbranch , String repourl,String credentialsId = "BitbucketRepo" ) {
    // Fetch the Git configuration based on the project
    def gitbranch = System.getenv('GIT_BRANCH') ?: error('Branch Name must be provided')  // Default to 'main' if GIT_BRANCH is not set
    def repourl = System.getenv('REPO_URL') ?: error('Repository URL must be provided')
    checkout([
        $class: "GitSCM",
        branches: [[name: "*/${gitbranch}"]],
        userRemoteConfigs: [[
            url: repourl,
            credentialsId: credentialsId
        ]]
    ])
}

