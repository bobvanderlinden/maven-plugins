package org.apache.maven.plugin.jxr.stubs;

/*
 * Copyright 2005-2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:oching@apache.org">Maria Odea Ching</a>
 */
public class AggregateSubmodule1MavenProjectStub
    extends MavenProjectStub
{
    List reportPlugins = new ArrayList();

    public AggregateSubmodule1MavenProjectStub()
    {
        setArtifactId( "aggregate-test-submodule1" );
        setGroupId( "aggregate.test" );
        setVersion( "1.0-SNAPSHOT" );
        setPackaging( "jar" );
        setInceptionYear( "2006" );

        String basedir = getBasedir().getAbsolutePath();
        List compileSourceRoots = new ArrayList();
        compileSourceRoots.add(
            basedir + "/src/test/resources/unit/aggregate-test/submodule1/aggregate/test/submodule1" );
        setCompileSourceRoots( compileSourceRoots );

        //set the report plugins
        List reportPlugins = new ArrayList();
        setReportPlugins( reportPlugins );

        Artifact artifact = new JxrPluginArtifactStub( getGroupId(), getArtifactId(), getVersion(), getPackaging() );
        artifact.setArtifactHandler( new DefaultArtifactHandlerStub() );
        setArtifact( artifact );
    }

    public void setReportPlugins( List reportPlugins )
    {
        this.reportPlugins = reportPlugins;
    }

    public List getReportPlugins()
    {
        return reportPlugins;
    }

}
