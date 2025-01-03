def call(String project) {
    // Get the Git configuration for the project
   def config = gitconfig("project")

   echo "Using Bitbucket credentails with username: ${config.GITHUB_CREDS}"
   echo "Checking out repository: ${config.git_url} on branch ${config.git_branch}"
}


