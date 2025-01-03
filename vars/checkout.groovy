def call(String project,def credentials) {
    // Get the Git configuration for the project
   def config = gitconfig(project,credentails)

   echo "Using Bitbucket credentails with username: ${config.GITHUB_CREDS}"
   echo "Checking out repository: ${config.git_url} on branch ${config.git_branch}"
}


