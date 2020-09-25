# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

DESCRIPTION = "i.MX U-Boot suppporting i.MX reference boards."
require recipes-bsp/u-boot/u-boot.inc
inherit pythonnative

PROVIDES += "u-boot"
DEPENDS_append = " python dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://source.codeaurora.org/external/imx/uboot-imx.git;protocol=https"
SRCBRANCH = "imx_v2018.03_4.14.98_2.1.0"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-Use-a-customize-device-tree-configuration-for-DRM.patch;md5sum=20e75b9224a9b1d7540e28156075e7f6" 
SRC_URI += "file://0002-MLK-22622-imx8m-Add-Workaround-for-ROM-SError-issue.patch;md5sum=2a6026216a5047e83f5cfc319914853d" 
SRC_URI += "file://0003-tee-add-OP-TEE-driver.patch;md5sum=893cd5c784146a9ee6ec6d7b1a06743c" 
SRC_URI += "file://0004-Enable-OPTEE-driver.patch;md5sum=a70fdaf749e5bed308f586b5f542c3cb" 
SRC_URI += "file://0005-Add-UCLASS_TEE-for-Trusted-Execution-Environment.patch;md5sum=3c53f7d2025c5c0fdb8c0a46b18cfdd6" 
SRC_URI += "file://0006-firmware-psci-introduce-SPL_ARM_PSCI_FW.patch;md5sum=c84fc6c01fca908ddca46c84825fd695" 
SRC_URI += "file://0007-MMIOT-534-Fix-compilation-issue-with-yocto.patch;md5sum=ca2e5d51f170babde6f1d0b363c85e53" 
SRC_URI += "file://0008-tee-optee-support-AVB-trusted-application.patch;md5sum=ffbd7a39239825c3d386a4416eee972b" 
SRC_URI += "file://0009-tee-change-return-code-for-REE-FS-supplicant-cmd.patch;md5sum=19ff8417f590cdaa03a759012f125491" 
SRC_URI += "file://0010-MMIOT-117-Add-support-of-secure-HDCP-control-for-OPT.patch;md5sum=1f6394bee8571d0dde44858760d22b04" 
SRCREV = "b9dc0acc7a29fc56012c7c2ebfff36a7ff3320ab"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

BOOT_TOOLS = "imx-boot-tools"

do_deploy_append_mx8m () {
    # Deploy the mkimage, u-boot-nodtb.bin and fsl-imx8mq-XX.dtb for mkimage to generate boot binary
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            i=$(expr $i + 1);
            for type in ${UBOOT_CONFIG}; do
                j=$(expr $j + 1);
                if [ $j -eq $i ]
                then
                    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/arch/arm/dts/${UBOOT_DTB_NAME}  ${DEPLOYDIR}/${BOOT_TOOLS}
                    install -m 0777 ${B}/${config}/tools/mkimage  ${DEPLOYDIR}/${BOOT_TOOLS}/mkimage_uboot
                    install -m 0777 ${B}/${config}/u-boot-nodtb.bin  ${DEPLOYDIR}/${BOOT_TOOLS}/u-boot-nodtb.bin-${MACHINE}-${UBOOT_CONFIG}
                fi
            done
            unset  j
        done
        unset  i
    fi

}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

UBOOT_NAME_mx6 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx8 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
