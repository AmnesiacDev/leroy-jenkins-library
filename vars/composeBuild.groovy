def call(String service_name, String env_file = null) {
    try {
        if (env_file?.trim()) {
            sh "docker compose --env-file '${env_file}' build '${service_name}'"
        } else {
            sh "docker compose build '${service_name}'"
        }
    } catch (err) {
        currentBuild.result = 'FAILURE'
        error("ERROR: failed at Build with -> ${err}")
    }
}
