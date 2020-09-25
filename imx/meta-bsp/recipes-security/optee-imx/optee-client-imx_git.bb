# Copyright (C) 2017-2020 NXP

SUMMARY = "OPTEE Client libs"
HOMEPAGE = "http://www.optee.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=69663ab153298557a59c67a60a743e5b"

inherit pythonnative systemd

SRCBRANCH = "imx_5.4.3_2.0.0"
OPTEE_CLIENT_SRC ?= "git://source.codeaurora.org/external/imx/imx-optee-client.git;protocol=https"
SRC_URI = "${OPTEE_CLIENT_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-MMIOT-181-Move-tee-supplicant-libteec.so-to-vendor-p.patch;md5sum=fda8742a5ddd6d81edcfb99f3a565bbf" 
SRC_URI += "file://0002-Android.mk-config.mk-move-teec.log-teesupp.log-under.patch;md5sum=5623921158fd3594b4609e70185514a3" 
SRC_URI += "file://0003-Android-related-files-changes-to-work-with-Treble-en.patch;md5sum=ac21d543c0c7c5c1ae2eb0e7a77e341c" 
SRC_URI += "file://0004-optee-rpmb-fix-access-to-physical-RPMB-partition.patch;md5sum=071910455bd31b6f82bf977f86b3bd38" 
SRC_URI += "file://0005-MMIOT-202-Disable-RPMB-ioctl-s-emulation.patch;md5sum=4e02998d5fe7486d6465bdd9db8101f2" 
SRC_URI += "file://0006-tee-supplicant-rpmb.c-add-__attribute__-fallthrough.patch;md5sum=c6b57d9471c6742e29e1eded6c8f51d9" 
SRC_URI += "file://0007-config-tee_supplicant_android-.mk-improve-legibility.patch;md5sum=dee277935661039aa96cb92e24a61d54" 
SRC_URI += "file://0008-simplify-use-of-TEE-fs-related-configs.patch;md5sum=d8f86205b9e0e9f91b4588c8c536ebad" 
SRC_URI += "file://0009-CFG_TEE_FS_PARENT_PATH-now-include-tee.patch;md5sum=1069afa199ad1dfde4800f910749c970" 
SRC_URI += "file://0010-Protect-memcpy-against-client-application-providing-.patch;md5sum=96a4312fbe5fae89ac77f41be5ec4e31" 
SRCREV = "bc0ec8ce1e4dc5ae23f4737ef659338b7cd408fe"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://tee-supplicant.service"

S = "${WORKDIR}/git"
SYSTEMD_SERVICE_${PN} = "tee-supplicant.service"

EXTRA_OEMAKE = "${@bb.utils.contains('DISTRO_FEATURES', 'sdp', 'CFG_SECURE_DATA_PATH=y', '', d)}"

do_compile () {
    if [ ${DEFAULTTUNE} = "aarch64" ]; then
        oe_runmake -C ${S} ARCH=arm64
    else
        oe_runmake -C ${S} ARCH=arm
    fi
}

do_install () {
	oe_runmake install

	install -D -p -m0644 ${S}/out/libteec/libteec.so.1.0 ${D}${libdir}/libteec.so.1.0
	ln -sf libteec.so.1.0 ${D}${libdir}/libteec.so
	ln -sf libteec.so.1.0 ${D}${libdir}/libteec.so.1

	install -D -p -m0755 ${S}/out/export/usr/sbin/tee-supplicant ${D}${bindir}/tee-supplicant

	cp -a ${S}/out/export/usr/include ${D}/usr/

	sed -i -e s:/etc:${sysconfdir}:g -e s:/usr/bin:${bindir}:g ${WORKDIR}/tee-supplicant.service
	install -D -p -m0644 ${WORKDIR}/tee-supplicant.service ${D}${systemd_system_unitdir}/tee-supplicant.service
}

PACKAGES += "tee-supplicant"
FILES_${PN} += "${libdir}/* ${includedir}/*"
FILES_tee-supplicant += "${bindir}/tee-supplicant"

INSANE_SKIP_${PN} = "ldflags dev-elf"
INSANE_SKIP_${PN}-dev = "ldflags dev-elf"
INSANE_SKIP_tee-supplicant = "ldflags"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"
