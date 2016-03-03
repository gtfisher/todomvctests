# Serenity Screenplay Project

This is a Serenity project that has used the  [Serenity Screenplay Tutorial](http://thucydides.info/docs/articles/screenplay-tutorial.html)
as the starting point, following the tutorial to get all the todomvc features in, & retaining the
  search features from the maven archetype.
  
## Added Serenity RestAssured Plugin
  
  As the idea was to look at using the Screenplay pattern to test some REST services, the Serenity Rest assured plugin has been added to the project.
  As guidance for setting this up the the [Serenity Demos](https://github.com/serenity-bdd/serenity-demos)
  were used specifically the [AddAPetToThePetStoreTest.java](https://github.com/serenity-bdd/serenity-demos/blob/master/junit-webtests/src/test/java/net/thucydides/showcase/junit/features/petstore/AddAPetToThePetStoreTest.java)
  example. This has then been modified to add a similar test but to use the Screeenplay pattern
   