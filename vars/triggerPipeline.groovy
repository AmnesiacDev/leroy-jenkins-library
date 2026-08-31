def call(String job_name){
    def result = build job: "${job_name}", wait: true, propagate: false
    echo "Backend pipeline (build/test/debug/deploy) result: ${result.result}"
    if (result.result != 'SUCCESS') {
        unstable("Backend downstream pipeline did not succeed beepboop: ${result.result}")
    }
    return result
}
