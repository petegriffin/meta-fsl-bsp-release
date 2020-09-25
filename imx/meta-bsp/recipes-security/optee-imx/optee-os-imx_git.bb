# Copyright (C) 2017-2020 NXP

SUMMARY = "OPTEE OS"
DESCRIPTION = "OPTEE OS"
HOMEPAGE = "http://www.optee.org/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c1f21c4f72f372ef38a5a4aee55ec173"

inherit deploy pythonnative autotools
DEPENDS = "python-pycrypto-native u-boot-mkimage-native"

SRCBRANCH = "imx_5.4.3_2.0.0"
OPTEE_OS_SRC ?= "git://source.codeaurora.org/external/imx/imx-optee-os.git;protocol=https;protocol=https"
SRC_URI = "${OPTEE_OS_SRC};branch=${SRCBRANCH}"

SRC_URI += "file://0001-TEE-485-drivers-crypto-implement-crypto-driver-DH.patch;md5sum=05b4cb0eff3369082db987deed7f11e1" 
SRC_URI += "file://0002-TEE-485-drivers-caam-implement-NXP-CAAM-DH.patch;md5sum=1c385256ec263b58e6dda58ae59467b8" 
SRC_URI += "file://0003-TEE-517-core-imx-Fix-DEK-Blob-support-for-i.MX-8msca.patch;md5sum=4c44078ad5593163f98d8f0e514a24cd" 
SRC_URI += "file://0004-TEE-517-core-imx-Add-dynamic-shared-memory-configura.patch;md5sum=e166ee294e4e6e676ffc67cbac833d0b" 
SRC_URI += "file://0005-TEE-450-Add-support-for-i.MX-8DXL.patch;md5sum=72e13afa5d378bf152da0ab89357b5dd" 
SRC_URI += "file://0006-TEE-521-core-imx-cleanup-i.MX-8QM-QxP-configuration.patch;md5sum=840ab71ff7fd2e42e28d229d50e9e86b" 
SRC_URI += "file://0007-TEE-525-core-imx-fix-i.MX-8mq-boot-failure.patch;md5sum=c04d20f9f5ec4ab0324770dbcd9cd719" 
SRC_URI += "file://0008-MLK-23577-core-imx-imx8mp-select-correct-job-ring-to.patch;md5sum=3235429748d0bd03ff4cd93256aa814d" 
SRC_URI += "file://0009-fix-warnings.patch;md5sum=71b47feef4b4caf69f310fbfe0b75ec7" 
SRC_URI += "file://0010-core-imx-64-bits-SDP-memory-taked-into-account.patch;md5sum=ab0882f0d0d11e46d28e87b9bc3bcc5c" 
SRC_URI += "file://0011-plat-imx-add-support-for-dynamic-shared-memory.patch;md5sum=b611a984826036f3a60576fb7da99489" 
SRC_URI += "file://0012-MMIOT-4-3-SDP-memory-mapped-without-cache-enabled-to.patch;md5sum=e2fd5ac5a98a2ecb789f566183f851ab" 
SRC_URI += "file://0013-MMIOT-20-Enable-TZASC-protection-on-Secure-Data-Path.patch;md5sum=8574b6bd397cd086d18143fc7223fe08" 
SRC_URI += "file://0014-core-crypto-add-support-MD5-hashes-in-RSA-sign-verif.patch;md5sum=9976ac7d14d3efc1246506eb92bfd701" 
SRC_URI += "file://0015-core-crypto-change-supported-HMAC-key-size-ranges.patch;md5sum=774c7460066486040bb629541c556bf6" 
SRC_URI += "file://0016-core-crypto-add-free-rsa-ecc-keypair-calls.patch;md5sum=14727ea14be8b31d89d49c1604e31a0a" 
SRC_URI += "file://0017-core-crypto-detect-elliptic-curve-size.patch;md5sum=a628146d0d9e4cbd2efa03f4623d2b84" 
SRC_URI += "file://0018-core-driver-crypto-add-support-MD5-hashes-in-RSA-sig.patch;md5sum=980cded51f4a05212adf721b76e3e56d" 
SRC_URI += "file://0019-Introduce-ASN1-ENUMERATED-tag-support.patch;md5sum=1ad796cfa385888a4650136b336d1b7a" 
SRC_URI += "file://0020-libutee-remove-restrictions-for-TEE_ALG_RSA_NOPAD.patch;md5sum=0ca3154af441c950a4dc00c0d39aa89f" 
SRC_URI += "file://0021-libtomcrypt-rsa-oaep-Use-SHA-1-by-default-for-MGF1.patch;md5sum=a56cdd628305f0ffbc0de450f4f65d88" 
SRC_URI += "file://0022-ltc-asn1-der-add-support-of-additional-types.patch;md5sum=b3dd98a6b673490cbb857cdb3a9032d9" 
SRC_URI += "file://0023-plat-imx-add-support-for-RPMB-and-early-TAs.patch;md5sum=2d9e00e3adeb40f4e230f885d66d110e" 
SRC_URI += "file://0024-ta-avb-Temporarily-disable-RPMB-functionalities.patch;md5sum=f716395d2cf0a8c7f4771d4af84cad76" 
SRC_URI += "file://0025-ta-avb-Adjust-AVB-operations-based-on-CFG_RPMB_FS-co.patch;md5sum=f2f9126aef6d94211771489132fddac2" 
SRC_URI += "file://0026-rpmb-configure-correct-dev_id-for-i.MX8mm-evk.patch;md5sum=7eecb6dbf718b01c173d1fc908bf5767" 
SRC_URI += "file://0027-rpmb-Use-default-configuration.patch;md5sum=25240fb48520d7e64480785171b77fcb" 
SRC_URI += "file://0028-MMIOT-232-Allow-to-block-RPMB-operations.patch;md5sum=b5c539197c49baf7a6fb274df8a18077" 
SRC_URI += "file://0029-MMIOT-232-Implement-a-Config-pseudo-TA.patch;md5sum=45221594ea686215ad2fcc403f2ba71b" 
SRC_URI += "file://0030-MMIOT-232-Solve-an-issue-to-write-lock-state.patch;md5sum=f05af443ef518fd590ace6dcf7a4a307" 
SRC_URI += "file://0031-MMIOT-278-Enable-RPMB-support-by-default.patch;md5sum=d67f9e2e89eda4a614e8de5a4ab580eb" 
SRC_URI += "file://0032-MMIOT-356-Lock-unlock-not-supported-if-CFG_RPMB_FS-n.patch;md5sum=b93f7ad4340ef83a072f9597f45356d9" 
SRC_URI += "file://0033-MMIOT-271-MMIOT-272-Add-AVB-TA-in-the-Early-TA.patch;md5sum=c4318fb511c57b173dfb01c144070146" 
SRC_URI += "file://0034-MMIOT-191-Add-secure-Hantro-VPU-PTA.patch;md5sum=de461e63e4e39389527611046b724ff8" 
SRC_URI += "file://0035-core-driver-caam-SDP-mem-cache-tested.patch;md5sum=768781277c14d7d3e9a94da613a9212b" 
SRC_URI += "file://0036-core-driver-disable-CAAM-AES-RSA.patch;md5sum=2b11684fa650a03c1fac037d77d624c1" 
SRC_URI += "file://0037-Set-memory-pool-size-to-16KB.patch;md5sum=f8c5c72464ee990c50db743e082cc8bc" 
SRC_URI += "file://0038-core-driver-disable-CAAM-ECC.patch;md5sum=e248cfc61e1d75630fcc654df65ce7f0" 
SRC_URI += "file://0039-MMIOT-117-Add-persistent-TA-to-protect-HDMI-HDCP-reg.patch;md5sum=8c2678f0ef8d5d5599558733332d05c6" 
SRC_URI += "file://0040-MMIOT-461-Add-CFG_RPMB_DISABLE_HASH_DB.patch;md5sum=d75cdc9ad05d22e0a588f1169b13bbef" 
SRC_URI += "file://0041-crypto-caam-disable-DH.patch;md5sum=f2da063dd20d37f67212118e0dd9cec0" 
SRC_URI += "file://0042-core-crypto-use-supplied-DSA-parameters-when-creatin.patch;md5sum=00d9d2cf2845d11e496cd160a9b36d66" 
SRC_URI += "file://0043-core-crypto-DH-make-sure-key_size-is-consistent-with.patch;md5sum=b6cb48e0314b7e11967eba091a440957" 
SRC_URI += "file://0044-core-crypto-ECC-make-sure-key_size-is-consistent-wit.patch;md5sum=73c0edb26915f540e3e9a383278f9f62" 
SRC_URI += "file://0045-libmbedtls-mbedtls_mpi_shrink-fix-possible-unwanted-.patch;md5sum=eab6f2c29c581195b28e6cb1dd318f65" 
SRC_URI += "file://0046-imx8mq-Add-a-warning-if-VPU-do-not-support-TZASC.patch;md5sum=15731ca36a334b5898d8cfb9c30b5340" 
SRC_URI += "file://0047-core-csu-add-imx8m-csu-protection.patch;md5sum=226a136286b45be208ba48d56500f3c9" 
SRC_URI += "file://0048-MMIOT-499-Increase-amount-of-MEM_AREA_RES_VASPACE-me.patch;md5sum=9c70008c4d7671f18b684dd6565f2f38" 
SRC_URI += "file://0049-core-csu-dump-state-when-trace-level-is-debug.patch;md5sum=a22d588fdcbfb020cfba65a075c5c67b" 
SRC_URI += "file://0050-Revert-core-driver-caam-SDP-mem-cache-tested.patch;md5sum=6febf13f7261a403f035bb2f4432416c" 
SRC_URI += "file://0051-TEE-526-core-arm-retrieve-SDP-Memory-cacheability.patch;md5sum=4c0d1962336c3dd9c9f49af47c00fae0" 
SRC_URI += "file://0052-TEE-526-drivers-caam-add-SDP-Memory-cacheability-ver.patch;md5sum=b6dad22c218b52835ea92fc2fa0e19f9" 
SRC_URI += "file://0053-TEE-491-drivers-crypto-implement-crypto-device-drive.patch;md5sum=cbf123f1c67f6030b962b55da377c763" 
SRC_URI += "file://0054-TEE-491-drivers-caam-rework-RSA-prime.patch;md5sum=5fd58fb7a3cfcfab6ad417a5217935da" 
SRC_URI += "file://0055-TEE-491-drivers-caam-implement-NXP-CAAM-DSA.patch;md5sum=502e871084ebbb0d0224fe3c814c7ba8" 
SRC_URI += "file://0056-TEE-465-drivers-caam-disable-job-ring-through-fdt-ov.patch;md5sum=903a8c3b4245101766ddc0d3d737783f" 
SRC_URI += "file://0057-TEE-510-drivers-caam-fix-mem_alloc-function.patch;md5sum=75427ed817be14c978d13c1f9d3bc2da" 
SRC_URI += "file://0058-TEE-510-drivers-caam-add-HAL-for-imx8qm-and-imx8qxp.patch;md5sum=6b340f4234c84e072fddaac03daff6af" 
SRC_URI += "file://0059-TEE-539-drivers-caam-use-pointers-to-out-inring_entr.patch;md5sum=e3ec97cc8e2bb75022cc2920af0c5bf2" 
SRC_URI += "file://0060-TEE-543-drivers-caam-move-NS-job-ring-assignment-lat.patch;md5sum=43d9deca4d64c1f9b223e8e7dc63029f" 
SRC_URI += "file://0061-MLK-23726-drivers-caam-Fix-CAAM-resume-function-for-.patch;md5sum=51439713268a78c5a86a7a404ed65098" 
SRC_URI += "file://0062-TEE-545-1-Instantiate-RNG-state-handle-with-Predicti.patch;md5sum=feef90113c3a2402ef63249679c2aa38" 
SRC_URI += "file://0063-TEE-546-drivers-caam-disable-interrupts-for-i.MX-7UL.patch;md5sum=d42309bf4afff070f48e0057bc491e5c" 
SRC_URI += "file://0064-TEE-527-drivers-caam-implement-CAAM-DMA-Object.patch;md5sum=4a58dc1946c2294f866dda755d9c07e5" 
SRC_URI += "file://0065-TEE-527-drivers-caam-add-dmaobj-descriptor-functions.patch;md5sum=bab030b68e099d22da4bf98bd7d0b4bc" 
SRC_URI += "file://0066-TEE-527-drivers-caam-use-CAAM-DMA-object-in-Hash.patch;md5sum=d26bc8d43845771c9e7131c9fcf52398" 
SRC_URI += "file://0067-TEE-527-drivers-caam-use-CAAM-DMA-object-in-HMAC.patch;md5sum=7afc499806a2b7b682b00e6cd0b105f9" 
SRC_URI += "file://0068-TEE-527-drivers-caam-use-CAAM-DMA-object-in-Cipher.patch;md5sum=8260993ec0eb90267ac38277c67150de" 
SRC_URI += "file://0069-TEE-527-drivers-caam-use-CAAM-DMA-object-in-RSA.patch;md5sum=9cc1c0edea9e66d91a541613c873f958" 
SRC_URI += "file://0070-TEE-527-drivers-caam-use-CAAM-DMA-object-in-ECC-driv.patch;md5sum=c33b1044d0791ccf6c65c54b5aa224ef" 
SRC_URI += "file://0071-TEE-527-drivers-caam-use-CAAM-DMA-object-in-DH-drive.patch;md5sum=e866573209d18d8bb6ba2eb9c89452d4" 
SRC_URI += "file://0072-TEE-527-drivers-caam-use-CAAM-DMA-object-in-DSA-driv.patch;md5sum=b5740f63b5ebb034beccb199897040de" 
SRC_URI += "file://0073-TEE-527-drivers-caam-use-CAAM-DMA-object-in-math-dri.patch;md5sum=f5906d2ae7b15af5c15ac836d0111d6f" 
SRC_URI += "file://0074-TEE-527-drivers-caam-use-CAAM-DMA-object-in-blob-dri.patch;md5sum=4c7b57ca3db42c50ee856a5c0f6104e3" 
SRC_URI += "file://0075-TEE-527-drivers-caam-use-CAAM-DMA-object-in-MP-drive.patch;md5sum=8f2dbb6713c6efb801599fd93e5fbab6" 
SRC_URI += "file://0076-TEE-527-drivers-caam-cleanup-driver.patch;md5sum=35c471e8eb7da9e1e05e3ff87d229a75" 
SRC_URI += "file://0077-TEE-559-drivers-caam-do-not-add-overlay-node-for-SCU.patch;md5sum=1bdfc440660d15815bc04a950c6fe596" 
SRC_URI += "file://0078-TEE-560-drivers-caam-Clean-log-of-caam_hal_sm_get_ba.patch;md5sum=cf66e4cba636927240d015a3b5f1d28e" 
SRC_URI += "file://0079-TEE-418-drivers-caam-fix-cipher-streaming.patch;md5sum=579f1ba2bbf7bd4a6cdcf82fa2fb4a3f" 
SRC_URI += "file://0080-MMIOT-353-enable-CAAM-Cipher-update-CAAM-driver.patch;md5sum=c0ec9b49af8cd67ca8cb63e38453cc78" 
SRC_URI += "file://0081-TEE-577-drivers-caam-fix-cipher-streaming-byte-per-b.patch;md5sum=ca9b1c1583861c132ac8005c498de1e5" 
SRC_URI += "file://0082-MMIOT-117-Add-parsing-of-HDCP-messages-to-set-HDCP-c.patch;md5sum=c2eaa1f2d29f15c7a81835b39967ca20" 
SRC_URI += "file://0083-MMIOT-191-Reduce-polling-loop-wait-time.patch;md5sum=d20027bbcc4b8b6b44251a4e017d6684" 
SRC_URI += "file://0084-Disable-CAAM-for-cryptographic-operations.patch;md5sum=f1a81fc7238ba80de3ee8063dac85d73" 
SRC_URI += "file://0085-MMIOT-538-Revert-Disable-CAAM-for-cryptographic-oper.patch;md5sum=98f11177d3a9978cce1807ae60cc9aeb" 
SRC_URI += "file://0086-MMIOT-388-Enable-RSA-CAAM-acceleration.patch;md5sum=d24bc9834fe808db3f047f52f00de0de" 
SRC_URI += "file://0087-MMIOT-564-imx8mq-MMC-Hack-Reverse-CID.patch;md5sum=c5698fcf3b8797b8868bcb03bffb2b22" 
SRCREV = "65d11b9078bed0d1fe2908b473a55e038db2280c"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build.${PLATFORM_FLAVOR}"

# The platform flavor corresponds to the Yocto machine without the leading 'i'.
PLATFORM_FLAVOR                 = "${@d.getVar('MACHINE')[1:]}"
PLATFORM_FLAVOR_imx6qpdlsolox   = "mx6qsabresd"
PLATFORM_FLAVOR_imx6ul7d        = "mx6ulevk"
PLATFORM_FLAVOR_imx6ull14x14evk = "mx6ullevk"
PLATFORM_FLAVOR_imx6ull9x9evk   = "mx6ullevk"
PLATFORM_FLAVOR_imx6ulz14x14evk = "mx6ullevk"
PLATFORM_FLAVOR_mx8mm   = "mx8mmevk"
PLATFORM_FLAVOR_imx8qmqxp   = "mx8qmmek"

OPTEE_ARCH ?= "arm32"
OPTEE_ARCH_armv7a = "arm32"
OPTEE_ARCH_aarch64 = "arm64"

CFG_RPMB_FS ?= "y"

# Optee-os can be built for 32 bits and 64 bits at the same time
# as long as the compilers are correctly defined.
# For 64bits, CROSS_COMPILE64 must be set
# When defining CROSS_COMPILE and CROSS_COMPILE64, we assure that
# any 32 or 64 bits builds will pass
EXTRA_OEMAKE = "PLATFORM=imx PLATFORM_FLAVOR=${PLATFORM_FLAVOR} \
                CROSS_COMPILE=${HOST_PREFIX} \
                CROSS_COMPILE64=${HOST_PREFIX} \
                NOWERROR=1 \
                LDFLAGS= \
		O=${B} \
        "

EXTRA_OEMAKE_append = " ${@bb.utils.contains('DISTRO_FEATURES', 'sdp', \
               'CFG_SECURE_DATA_PATH=y \
                CFG_TEE_SDP_MEM_BASE=0xCC000000 \
                CFG_TEE_SDP_MEM_SIZE=0x02000000 \
                CFG_TEE_SDP_NONCACHE=y \
                CFG_DRM_SECURE_DATA_PATH=y \
                CFG_RDC_SECURE_DATA_PATH=y \
                CFG_RDC_DECODED_BUFFER_BASE=0xCE000000 \
                CFG_RDC_DECODED_BUFFER_SIZE=0x30000000 \
                CFG_HANTRO_VPU_PTA=y', '', d)}"

do_compile () {
    unset LDFLAGS
    export CFLAGS="${CFLAGS} --sysroot=${STAGING_DIR_HOST}"
    export CFG_RPMB_FS=${CFG_RPMB_FS}
    #export CFG_RPMB_WRITE_KEY="y"
    #export CFG_RPMB_RESET_FAT="y"
    export CFG_CORE_HEAP_SIZE="524288"
    export CFG_RPMB_DISABLE_HASH_DB="y"
    export CFG_NUM_THREADS="4"
    oe_runmake -C ${S} all CFG_TEE_TA_LOG_LEVEL=1
#    oe_runmake -C ${S} all CFG_TEE_CORE_LOG_LEVEL=3 CFG_TEE_TA_LOG_LEVEL=3 DEBUG=1
}


do_deploy () {
    install -d ${DEPLOYDIR}
    ${TARGET_PREFIX}objcopy -O binary ${B}/core/tee.elf ${DEPLOYDIR}/tee.${PLATFORM_FLAVOR}.bin

    if [ "${OPTEE_ARCH}" != "arm64" ]; then
        IMX_LOAD_ADDR=`cat ${B}/core/tee-init_load_addr.txt` && \
        uboot-mkimage -A arm -O linux -C none -a ${IMX_LOAD_ADDR} -e ${IMX_LOAD_ADDR} \
            -d ${DEPLOYDIR}/tee.${PLATFORM_FLAVOR}.bin ${DEPLOYDIR}/uTee-${OPTEE_BIN_EXT}
    fi

    cd ${DEPLOYDIR}
    ln -sf tee.${PLATFORM_FLAVOR}.bin tee.bin
    cd -
}

do_install () {
    install -d ${D}/lib/firmware/
    install -m 644 ${B}/core/*.bin ${D}/lib/firmware/

    # Install the TA devkit
    install -d ${D}/usr/include/optee/export-user_ta_${OPTEE_ARCH}/

    for f in ${B}/export-ta_${OPTEE_ARCH}/*; do
        cp -aR $f ${D}/usr/include/optee/export-user_ta_${OPTEE_ARCH}/
    done
}

addtask deploy after do_compile before do_install


FILES_${PN} = "/lib/firmware/"
FILES_${PN}-dev = "/usr/include/optee"
INSANE_SKIP_${PN}-dev = "staticdev"

COMPATIBLE_MACHINE = "(mx6|mx7|mx8)"

PACKAGE_ARCH = "${MACHINE_ARCH}"
