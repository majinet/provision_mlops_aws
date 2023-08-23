/*
 * OIDC discovery with the sample application
 */
response = new Response(Status.OK)
response.getHeaders().put(ContentTypeHeader.NAME, "text/html");
response.entity = """
<!doctype html>
<html>
  <head>
    <title>OpenID Connect Discovery</title>
    <meta charset='UTF-8'>
  </head>
  <body>
    <form id='form' action='/discovery/login?'>
      Enter your user ID or email address:
        <input type='text' id='discovery' name='discovery'
          placeholder='majinet@whatautomatech.com' />
        <input type='hidden' name='goto'
          value='${contexts.router.originalUri}' />
    </form>
    <script>
      // Make sure sampleAppUrl is correct for your sample app.
      window.onload = function() {
      document.getElementById('form').onsubmit = function() {
      // Fix the URL if not using the default settings.
      var sampleAppUrl = 'https://kubeflow.platform.whatautomatech.com/';
      var discovery = document.getElementById('discovery');
      discovery.value = sampleAppUrl + discovery.value.split('@', 1)[0];
      };
    };
    </script>
  </body>
</html>""" as String
return response