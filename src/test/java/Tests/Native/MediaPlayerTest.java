/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package Tests.Native;

import Pages.Native.MediaPlayerPage;
import Tests.AbstractBaseTests.NativeTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Tests for media player
 */
public class MediaPlayerTest extends NativeTests {
    private static final String MEDIA_PLAYER_CONTENT_DESCRIPTION = "Content Playing";
    private MediaPlayerPage mediaPlayerPage;

    /**
     * Sets the page view index so it can be navigated to
     *
     * @return the pageview index
     */
    @Override
    public int pageIndex() {
        return 2;
    }

    /**
     * Creates media player page
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        mediaPlayerPage = new MediaPlayerPage(driver);
    }

    /**
     * Test if the media player's content description is playing
     */
    @Test
    public void testIfMediaPlayerIsPlaying() {
        Assert.assertEquals(mediaPlayerPage.getMediaPlayerStatus(), MEDIA_PLAYER_CONTENT_DESCRIPTION);
    }
}
