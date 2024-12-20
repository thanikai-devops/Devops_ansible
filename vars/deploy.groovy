def call(String environment = "dev") {
    script {
       if (environment == "dev"){
        echo "Deploying to Development (dev) environment."
       }
       else (environment == "UAT"){
        echo "Deploying to Development (UAT) environment."
       }
    }
}
