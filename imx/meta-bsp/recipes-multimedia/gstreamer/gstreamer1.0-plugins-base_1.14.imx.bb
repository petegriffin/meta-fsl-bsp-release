require recipes-multimedia/gstreamer/gstreamer1.0-plugins-base.inc

# Re-use patch files from 1.12.2 recipe
FILESEXTRAPATHS_prepend := "${BSPDIR}/sources/poky/meta/recipes-multimedia/gstreamer/files:"
FILESEXTRAPATHS_prepend := "${BSPDIR}/sources/poky/meta/recipes-multimedia/gstreamer/gstreamer1.0-plugins-base:"
# The following PATH has highest priority
# Implement patch overwrite, using the updated patch under this PATH, instead of the 1.12.2 ones
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=c54ce9345727175ff66d17b67ff51f58 \
                    file://COPYING.LIB;md5=6762ed442b3822387a51c92d928ead0d \
                    file://common/coverage/coverage-report.pl;beginline=2;endline=17;md5=a4e1830fce078028c8f0974161272607"

DEPENDS_append_imxgpu2d = " virtual/libg2d"

# Enable pango lib
PACKAGECONFIG_append = " pango "

# Remove gio-unix-2.0 as it does not seem to exist anywhere
PACKAGECONFIG_remove = "gio-unix-2.0"
# Overwrite the unrecognised option which is set in gstreamer1.0-plugins-base.inc under poky layer
PACKAGECONFIG[gio-unix-2.0] = ""

EXTRA_OECONF_append = " --disable-opengl --enable-wayland"

GST1.0-PLUGINS-BASE_SRC ?= "gitsm://source.codeaurora.org/external/imx/gst-plugins-base.git;protocol=https"
SRCBRANCH = "MM_04.04.07_1906_L4.14.98"

SRC_URI = " \
    ${GST1.0-PLUGINS-BASE_SRC};branch=${SRCBRANCH} \
    file://0001-introspection.m4-prefix-pkgconfig-paths-with-PKG_CON.patch \
    file://make-gio_unix_2_0-dependency-configurable.patch \
"

SRC_URI += "file://0001-gstionmemory-Implement-another-ION-allocator-instanc.patch;md5sum=38df4759def3cf76eca4bc4781bcb10c" 
SRC_URI += "file://0002-allocators-Support-secure-ION-buffers.patch;md5sum=e829b443aa98540f930ab59e1741b59d" 
SRC_URI += "file://0003-fdmemory-Allocate-fixed-size-4-MB-shared-data-for-ea.patch;md5sum=c25f34bd3c142969a3bc9c1505d64a21" 
SRC_URI += "file://0004-MMIOT-498-Restore-the-default-ion-allocator-and-crea.patch;md5sum=7bcbd9c4454fa2798af62664cd6a33b0" 
SRCREV = "5e8cc757e4fec72ee007ac12fab2d1333fce1dc9" 

inherit use-imx-headers

EXTRA_AUTORECONF = ""

EXTRA_OECONF = "CPPFLAGS="-I${STAGING_INCDIR_IMX}""

EXTRA_OEMAKE += "GIR_EXTRA_LIBS_PATH=${GIR_EXTRA_LIBS_PATH}:${B}/gst-libs/gst/allocators/.libs"

FILES_${PN} += "${libdir}/gstreamer-1.0/include"

PV = "1.14.4.imx"

S = "${WORKDIR}/git"

