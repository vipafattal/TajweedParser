[![](https://jitpack.io/v/vipafattal/TajweedParser.svg)](https://jitpack.io/#vipafattal/TajweedParser)

# TajweedParser
Tajweed Quran Parser bassed on [quran-tajweed](http://api.alquran.cloud/v1/quran/quran-tajweed)

# Setup

#### Step 1
add to your project build.gradle at the end of repositories
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### Step 2
add the dependency to the `build.gradle` app module:
```groovy
implementation 'com.github.vipafattal:TajweedParser:1.0.0.1'
```

#### Usage

The library is based on https://alquran.cloud/api, on edition `quran-tajweed`.Once you have `quran-tajweed` inside the app you can call `TajweedHelper.getStyledAyah(Aya.text)` to return a [Spannable](https://developer.android.com/reference/android/text/Spannable) text. Use TextView widgets with Spannable text.

```kotlin
val ayaTextView: TextView = findViewById(R.id.ayahText)
ayaTextView.text = TajweedHelper.getStyledAyah(aya.text)
```

You can also change the colors by creating a class of `MetaColors` and overriding the color properties:
```Kotlin
val metaColors = MetaColors(hsl = "#FF6200EE", ikhafa = "#D50000")
TajweedHelper.setTajweedMetasColor(metaColors)
```
then use `setTajweedMetasColor(MetaColors)` to force library to use your custom colors.

```Kotlin
TajweedHelper.setTajweedMetasColor(customMetaColors)
```

# Full Example
See the [app](https://github.com/vipafattal/TajweedParser/blob/master/test.png) module for full example.

You can also download the apk from this [link](https://drive.google.com/file/d/10EbERrszIuVqBfxIQkm5whGXcHjibpG5/view?usp=sharing).

<p align="center">
<img src="https://github.com/vipafattal/TajweedParser/blob/master/test.png" width=35% >
</p>

# Styles
This table of the Tajweed metas of the `quran-tajweed` (obtained from [link](https://github.com/vipafattal/alquran-tools/blob/master/docs/tajweed.md)):

# The  Library Functionality 
This library takes the output of the Tajweed edition, and creates a Spannalbe Android Widget friendly text.
It uses the table below to parse what the API returns and converts it to something you can use with TextViews widgets.

<table>
    <thead>
        <tr>
            <th>Type</th>
            <th>Identifier</th>
            <th>Colour</th>
            <th>Variable Name</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
                    <tr>
                <td class="ham_wasl">hamza-wasl</td>
                <td>[h</td>
                <td style="background-color: #000000">#AAAAAA</td>
                <td>hsl</td>
                <td>Hamzat ul Wasl</td>
            </tr>
                    <tr>
                <td class="slnt">silent</td>
                <td>[s</td>
                <td style="background-color: #000000">#AAAAAA</td>
                <td>hsl</td>
                <td>Silent</td>
            </tr>
                    <tr>
                <td class="slnt">laam-shamsiyah</td>
                <td>[l</td>
                <td style="background-color: #000000">#AAAAAA</td>
                <td>hsl</td>
                <td>Lam Shamsiyyah</td>
            </tr>
                    <tr>
                <td class="madda_normal">madda-normal</td>
                <td>[n</td>
                <td style="background-color: #537FFF">#537FFF</td>
                <td>madda_normal</td>
                <td>Normal Prolongation: 2 Vowels</td>
            </tr>
                    <tr>
                <td class="madda_permissible">madda-permissible</td>
                <td>[p</td>
                <td style="background-color: #4050FF">#4050FF</td>
                <td>madda_permissible</td>
                <td>Permissible Prolongation: 2, 4, 6 Vowels</td>
            </tr>
         </tr>
                    <tr>
                <td class="madda_necesssary">madda-necesssary</td>
                <td>[m</td>
                <td style="background-color: #000EBC">#000EBC</td>
                <td>madda_necessary</td>
                <td>Necessary Prolongation: 6 Vowels</td>
            </tr>
                    <tr>
                <td class="qlq">qalaqah</td>
                <td>[q</td>
                <td style="background-color: #DD0008">#DD0008</td>
                <td>qlq</td>
                <td>Qalaqah</td>
            </tr>
                    <tr>
                <td class="madda_pbligatory">madda-obligatory</td>
                <td>[o</td>
                <td style="background-color: #2144C1">#2144C1</td>
                <td>madda_pbligatory</td>
                <td>Obligatory Prolongation: 4-5 Vowels</td>
            </tr>
                    <tr>
                <td class="ikhf_shfw">ikhafa-shafawi</td>
                <td>[c</td>
                <td style="background-color: #D500B7">#D500B7</td>
                <td>ikhf_shfw</td>
                <td>Ikhafa' Shafawi - With Meem</td>
            </tr>
                    <tr>
                <td class="ikhf">ikhafa</td>
                <td>[f</td>
                <td style="background-color: #9400A8">#9400A8</td>
                <td>ikhf</td>
                <td>Ikhafa'</td>
            </tr>
                    <tr>
                <td class="idghm_shfw">idgham-shafawi</td>
                <td>[w</td>
                <td style="background-color: #58B800">#58B800</td>
                <td>idghm_shfw</td>
                <td>Idgham Shafawi - With Meem</td>
            </tr>
                    <tr>
                <td class="iqlb">iqlab</td>
                <td>[i</td>
                <td style="background-color: #26BFFD">#26BFFD</td>
                <td>iqlb</td>
                <td>Iqlab</td>
            </tr>
                    <tr>
                <td class="idgh_ghn">idgham-without-ghunnah</td>
                <td>[a</td>
                <td style="background-color: #169777">#169777</td>
                <td>idgh_ghn</td>
                <td>Idgham - With Ghunnah</td>
            </tr>
                    <tr>
                <td class="idgh_w_ghn">idgham-without-ghunnah</td>
                <td>[u</td>
                <td style="background-color: #169200">#169200</td>
                <td>idgh_w_ghn</td>
                <td>Idgham - Without Ghunnah</td>
            </tr>
                    <tr>
                <td class="idgh_mus">idgham-mutajanisayn</td>
                <td>[d</td>
                <td style="background-color: #A1A1A1">#A1A1A1</td>
                <td>idgh_mus</td>
                <td>Idgham - Mutajanisayn</td>
            </tr>
                    <tr>
                <td class="idgh_mus">idgham-mutaqaribayn</td>
                <td>[b</td>
                <td style="background-color: #A1A1A1">#A1A1A1</td>
                <td>idgh_mus</td>
                <td>Idgham - Mutaqaribayn</td>
            </tr>
                    <tr>
                <td class="ghn">ghunnah</td>
                <td>[g</td>
                <td style="background-color: #FF7E1E">#FF7E1E</td>
                <td>ghn</td>
                <td>Ghunnah: 2 Vowels MIMM/NOON with SHADEH</td>
            </tr>
            </tbody>
</table>

for more information go to see the docs at [link1](https://github.com/islamic-network/alquran-tools/blob/master/docs/tajweed.md) and [link2](https://alquran.cloud/tajweed-guide).

# Credits

Big thanks for [Meezaan](https://github.com/meezaan) for help and the useful API.
