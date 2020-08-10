package com.amazonaws.glue.catalog.metastore;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaHookLoader;
import org.apache.hadoop.hive.metastore.IMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.ql.metadata.HiveMetaStoreClientFactory;

public class AWSGlueDataCatalogHiveClientFactory implements HiveMetaStoreClientFactory {

  @Override
  public IMetaStoreClient createMetaStoreClient(
      HiveConf conf,
      HiveMetaHookLoader hookLoader
  ) throws MetaException {
    Properties prop = conf.getAllProperties();
    for (String key: prop.stringPropertyNames()) {
        System.out.println(key + ": " + prop.getProperty(key));
    }
    AWSCatalogMetastoreClient client = new AWSCatalogMetastoreClient(conf, hookLoader);
    return client;
  }

}
