def call(String image_name, String command = 'echo Success'){
  try {
        sh """
            docker run --rm \
              --entrypoint sh \
              ${image_name} \
              -c "${command}"
        """
      } catch (err) {
          currentBuild.result = 'FAILURE'
          error("Backend unit tests failed: ${err}")
      }
}
