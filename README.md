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
  -DgroupId=tmp1.tmp2.tmp3 \
  -DartifactId=tmp4.tmp5.tmp6 \
  -Dversion=1.0.0-SNAPSHOT \
  -Dpackage=tmp7.tmp8.tmp9
```

