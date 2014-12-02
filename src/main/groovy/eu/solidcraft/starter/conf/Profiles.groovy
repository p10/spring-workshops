package eu.solidcraft.starter.conf

import groovy.transform.CompileStatic;

@CompileStatic
interface Profiles {
    String DEVELOPMENT = 'starter.development'
    String PRODUCTION = 'starter.production'
    String TEST = 'starter.test'
    String ASPECTTEST = 'starter.aspecttest'
    String DEFAULT = 'default'
}