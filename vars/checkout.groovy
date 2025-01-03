def call(String project) {
    // Fetch the Git configuration based on the project
    def config = gitconfig(project)
    url: config.git_url
    branch: config.git_branch
}
