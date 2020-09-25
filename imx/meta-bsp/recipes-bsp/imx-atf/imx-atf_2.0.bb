# Copyright 2017-2018 NXP

DESCRIPTION = "i.MX ARM Trusted Firmware"
SECTION = "BSP"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

inherit fsl-eula-unpack pkgconfig deploy

PV = "2.0+git${SRCPV}"

ATF_SRC ?= "git://source.codeaurora.org/external/imx/imx-atf.git;protocol=https"
SRCBRANCH = "imx_4.14.98_2.1.0"

SRC_URI = "${ATF_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-MLK-22207-plat-imx8m-Fix-the-data-sync-issue-in-dram.patch;md5sum=d3608a79ef3e29ea8525f747f99778d5" 
SRC_URI += "file://0002-Revert-plat-imx8mm-change-DISPMIX-power-domain-handl.patch;md5sum=a33ff93fa0f4952d7b321c847694ca78" 
SRC_URI += "file://0003-MMIOT-244-On-secure-closed-board-linux-can-t-configu.patch;md5sum=2b1d0eb911d9babc094c3ef7b48de8c3" 
SRC_URI += "file://0004-MMIOT-191-Do-not-prevent-VPU-to-decode-in-CMA.patch;md5sum=386725becb0fd8a75fe9cedc2e06edd6" 
SRC_URI += "file://0005-MMIOT-193-Setup-CSU-VPU-access-in-TZ-only.patch;md5sum=761a82105b87d42b82ed65b75db485c4" 
SRC_URI += "file://0006-MMIOT-193-imx8mm-csu-config-updated-with-Secure-VPU-.patch;md5sum=1143148b8b931736613e28cdf4de9043" 
SRC_URI += "file://0007-MMIOT-193-Fix-CFG_SECURE_HANTRO_VPU-flag-definition.patch;md5sum=ddbec398cd78fdc153c07cd678d02d75" 
SRC_URI += "file://0008-MMIOT-412-Add-PCIe-slave-in-default-CSU-configuratio.patch;md5sum=b8ac45c410b5e90014378fdfc5af8e4f" 
SRC_URI += "file://0009-MMIOT-117-Protect-HDCP-HDMI-registers-with-CSU-when-.patch;md5sum=3068589099593e5d239a2bc2535f6fe4" 
SRCREV = "727cf896a4c79d152dae4537e28400c747bf39b9"

S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"

SOC_ATF ?= "imx8qm"
SOC_ATF_mx8qm = "imx8qm"
SOC_ATF_mx8qxp = "imx8qx"
SOC_ATF_mx8mq = "imx8mq"
SOC_ATF_mx8mm = "imx8mm"
SOC_ATF_mx8mn = "imx8mn"

SYSROOT_DIRS += "/boot"

BUILD_OPTEE = "${@bb.utils.contains('COMBINED_FEATURES', 'optee', 'true', 'false', d)}"

EXTRA_OEMAKE_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', \
                         'DECRYPTED_BUFFER_START=0xCC000000 \
                          DECRYPTED_BUFFER_LEN=0x02000000 \
                          DECODED_BUFFER_START=0xCE000000 \
                          DECODED_BUFFER_LEN=0x30000000 \
                          CFG_SECURE_HANTRO_VPU=y', '', d)}"

do_compile () {
    export CROSS_COMPILE="${TARGET_PREFIX}"
    cd ${S}
    # Clear LDFLAGS to avoid the option -Wl recognize issue
    unset LDFLAGS

    echo "-> Build ${SOC_ATF} bl31.bin"
    # Set BUIL_STRING with the revision info
    BUILD_STRING=""
    if [ -e ${S}/.revision ]; then
        cur_rev=`cat ${S}/.revision`
        echo " Current revision is ${cur_rev} ."
        BUILD_STRING="BUILD_STRING=${cur_rev}"
    else
        echo " No .revision found! "
    fi
    oe_runmake clean PLAT=${SOC_ATF}
    oe_runmake ${BUILD_STRING} PLAT=${SOC_ATF} bl31

    # Build opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        oe_runmake clean PLAT=${SOC_ATF} BUILD_BASE=build-optee
        oe_runmake ${BUILD_STRING} PLAT=${SOC_ATF} BUILD_BASE=build-optee SPD=opteed bl31
    fi
    unset CROSS_COMPILE
}

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/build/${SOC_ATF}/release/bl31.bin ${D}/boot/bl31-${SOC_ATF}.bin
    # Install opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        install -m 0644 ${S}/build-optee/${SOC_ATF}/release/bl31.bin ${D}/boot/bl31-${SOC_ATF}.bin-optee
    fi
}

do_deploy () {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${S}/build/${SOC_ATF}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${SOC_ATF}.bin
    # Deploy opteee version
    if [ "${BUILD_OPTEE}" = "true" ]; then
        install -m 0644 ${S}/build-optee/${SOC_ATF}/release/bl31.bin ${DEPLOYDIR}/${BOOT_TOOLS}/bl31-${SOC_ATF}.bin-optee
    fi
}

addtask deploy before do_install after do_compile

FILES_${PN} = "/boot"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx8)"
