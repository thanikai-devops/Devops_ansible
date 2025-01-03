def call(String project) {
    // Declaration Approach (Better for Scaling)
    // Declaration approach, you would have a variable (config) that is populated with the relevant values based on the project name
    def config = [:]
    if (project == 'gooplus-backend') {
        config = [
            // GITHUB_CREDS = credentials("BitbucketRepo")
            git_branch: "seran_dev",
            git_url: 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git'
        ]
    } else if (project == "astro-website") {
        config = [
            // git_credentials: credentials("BitbucketRepo"),
            git_branch: "dev_dafin",
            git_url: 'https://SciflareIT@bitbucket.org/web-sciflare/sciflare-website.git'
        ]
    } else {
        echo "Invalid Project Specified"  
    }
    return config
}