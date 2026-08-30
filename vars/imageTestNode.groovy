def call(String image_name){
  try {
        sh """
            docker run --rm \
              --entrypoint sh \
              ${IMAGE_NAME} \
              -c "npm ci && npm test"
        """
      } catch (err) {
          currentBuild.result = 'FAILURE'
          error("Backend unit tests failed: ${err}")
      }
}
