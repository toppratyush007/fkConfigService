# fkConfigService

configs are JSONs structures

simple key value pairs

they can inherit from other configs

and user permissions can be set on these configs for read and write

config a : { "a1": "va1","a2":"va2"  }, config b : { "a1":"vb1"  };
 b inherits from a then value of a1 and a2 from b are vb1 and va2
