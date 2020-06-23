# osgi-project-archetype

## build archetype

```
mvn clean install
```

## create project from archetype

```
mvn archetype:generate \
  -DarchetypeGroupId=de.maggu2810.maven.archetypes \
  -DarchetypeArtifactId=osgi-project-archetype \
  -DarchetypeVersion=1.0.0-SNAPSHOT \
  -DgroupId=tmp -DartifactId=tmp -Dversion=1.0.0-SNAPSHOT
```

