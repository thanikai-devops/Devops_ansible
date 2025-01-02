def call (String project){
// Declaration Approach (Better for Scaling)
// declaration approach, you would have a variable (config) that is populated with the relevant values based on the project name
    def config 
    if (project == 'gooplus') {
        config = [
        git_credentialsId: credentialsId("BitbucketRepo"),
        git_branch: "seran_dev"
        git_url: 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git'
       ]
    } else if (project == "astro-website"){
        config = [
        git_credentialsId: credentialsId("BitbucketRepo"),
        git_branch: "dev_dafin"
        git_url: 'https://SciflareIT@bitbucket.org/web-sciflare/sciflare-website.git'
       ]
    } else {
        echo "Invalid Project Specified"
    }
    return config 
}


// Inline Approach (Less Flexible for Scaling)
// def call(String project = 'repo1') {
//     if (project == 'repo1') {
//         return [
//             git_credentialsId: credentialsId("BitbucketRepo"),
//             git_branch: 'seran_dev',
//             git_url: 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus.git'
//         ]
//     } else if (project == 'repo2') {
//         return [
//             git_credentialsId: credentialsId("BitbucketRepo"),
//             git_branch: 'main',
//             git_url: 'https://SciflareIT@bitbucket.org/dpl11-backend/goo-plus-another.git'
//         ]
//     } else if (project == 'repo3') { // New project added
//         return [
//             git_credentialsId: credentialsId("BitbucketRepo"),
//             git_branch: 'develop',
//             git_url: 'https://SciflareIT@bitbucket.org/dpl11-backend/new-repo.git'
//         ]
//     } else {
//         error "Invalid project name specified"
//     }
// }
